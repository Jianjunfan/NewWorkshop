import yaml
import os
import boto3
from botocore.exceptions import ClientError

def _readconfigdatafromyml():
    config_yml = os.path.dirname(os.path.abspath(__file__)) + '/' + "configFileLocation.yml"
    print(config_yml)
    with open(config_yml, 'r') as ymlfile:
        try:
           cfg = yaml.load(ymlfile)
           return cfg
        except yaml.YAMLError as exc:
            print(exc)

# cfg = _readconfigdatafromyml()

def _read_config_file():
    config_data = _readconfigdatafromyml()
    bucket_name = config_data['configFileS3Info']['bucketName']
    env = os.environ.get('Env')
    bucket_name = env + '-' + bucket_name
    key_name = config_data['configFileS3Info']['keyName']
    print("bucket is {}, key is{} ".format(bucket_name,key_name),flush=True)

    s3 = boto3.client('s3')
    try:
        response = s3.get_object(Bucket=bucket_name, Key=key_name)
    except ClientError as e:
        # AllAccessDisabled error == bucket or object not found
        print("Exception during reading config file: ",format(e),flush=True)
        return None
    # Return an open StreamingBody object
    # print("response['Body'] is {}",format(response['Body'].read()),flush=True)
    global db_info_data
    db_info_data = yaml.load(response['Body'].read())
    print("db_info_data is ",format(db_info_data),flush=True)
    # for server in yaml_data['keyTableFiledNameList']['schemaDbInfo']:
    #     print("server info: ",format(server['serverAddress']))
    return db_info_data

def _read_sensitive_column_lists():

    # global sensitive_column_lists
    allowed_column_lists= []
    for db_server in db_info_data['keyTableFiledNameList']['schemaDbInfo']:
        for schema_name in db_server['schemaListName']:
            for table_info in schema_name['tableInfo']:
                allowed_column_lists.extend(table_info['allowedColumnList'])
    print("In _read_sensitive_column_lists, allowed_column_lists is {}".format(allowed_column_lists))
    allowed_column_lists = list(dict.fromkeys(allowed_column_lists))
    return allowed_column_lists

def _read_schema_list_name(schema_index):
    schema_name_lists=[]
    # for db_server in db_info_data['keyTableFiledNameList']['schemaDbInfo']:
    #     for schema_name in db_server['schemaListName']:
    #         schema_name_lists.append(schema_name['schemaName'])
    db_server = db_info_data['keyTableFiledNameList']['schemaDbInfo'][schema_index-1]
    for schema_name in db_server['schemaListName']:
        schema_name_lists.append(schema_name['schemaName'])
    return schema_name_lists

def _read_schema_table_map():
    schema_table_map={}
    for db_server in db_info_data['keyTableFiledNameList']['schemaDbInfo']:
        for schema_name in db_server['schemaListName']:
            table_list=[]
            for table_info in schema_name['tableInfo']:
                table_list.append(table_info['tableName'])
            schema_table_map[schema_name['schemaName']] = table_list
    
    return schema_table_map

def _read_schema_table_column_map():
    schema_table_column_map={}
    for db_server in db_info_data['keyTableFiledNameList']['schemaDbInfo']:
        for schema_name in db_server['schemaListName']:
            # table_list=[]
            table_column_map={}
            for table_info in schema_name['tableInfo']:
                # table_list.append(table_info['tableName'])
                table_column_map[table_info['tableName']] = table_info['allowedColumnList']
            schema_table_column_map[schema_name['schemaName']]=table_column_map
            # schema_table_map[schema_name['schemaName']] = table_list
    
    return schema_table_column_map

def _read_column_per_schema_table(schema_name, table_name):
    column_name_list=[]
    schema_table_column_map=_read_schema_table_column_map()
    print("in _read_column_per_schema_table, schema_table_column_map is{}".format(schema_table_column_map))

    column_name_list=schema_table_column_map[schema_name][table_name]
    print("in _read_column_per_schema_table, column_name_list is{}".format(column_name_list))

    return column_name_list

def _read_table_name_per_schema(schema_name):
    table_name_list=[]
    print("in _read_table_name_per_schema, schema name is {}".format(schema_name))
    schema_table_map=_read_schema_table_map()
    print("in _read_table_name_per_schema, schema_table_map is {}".format(schema_table_map))
    if schema_name in schema_table_map:
        table_name_list=schema_table_map[schema_name]

    print("in _read_table_name_per_schema. table_name_list is {}".format(table_name_list))
    return table_name_list

def _read_db_info():
    db_info_list=[]
    for db_server in db_info_data['keyTableFiledNameList']['schemaDbInfo']:
        db_info={}
        db_info['serverAddress'] = db_server['serverAddress']
        db_info['productName'] = db_server['productName']
        db_info['serverPort'] = db_server['serverPort']
        db_info['userName'] = db_server['userName']
        db_info_list.append(db_info)
    return db_info_list

def _read_db_password_info(serverAddress):
    db_info_list=[]
    productName=""
    userName=""
    db_info_list=_read_db_info()
    for db_info in db_info_list:
        if db_info['serverAddress'].lower() == serverAddress.lower():
            productName = db_info['productName']
            userName = db_info['userName']
            break

    if productName=="" or userName=="":
        print("Error when _read_db_password_info with productName: {} and userName {}",format(productName),foramt(userName),flush=True)
        return ""
    
    secret_name = "/configDeployment/product/"+ productName + "/db/" + userName+"/password"
    region_name = "us-east-1"
    print("In _read_db_password_info, the secret parameter _name is {}",format(secret_name),flush=True)
    # Create a Secrets Manager client
    session = boto3.session.Session()
    client = session.client(
        service_name='secretsmanager',
        region_name=region_name
    )

    try:
        get_secret_value_response = client.get_secret_value(
            SecretId=secret_name
        )
    except ClientError as e:
        if e.response['Error']['Code'] == 'DecryptionFailureException':
            # Secrets Manager can't decrypt the protected secret text using the provided KMS key.
            # Deal with the exception here, and/or rethrow at your discretion.
            raise e
        elif e.response['Error']['Code'] == 'InternalServiceErrorException':
            # An error occurred on the server side.
            # Deal with the exception here, and/or rethrow at your discretion.
            raise e
        elif e.response['Error']['Code'] == 'InvalidParameterException':
            # You provided an invalid value for a parameter.
            # Deal with the exception here, and/or rethrow at your discretion.
            raise e
        elif e.response['Error']['Code'] == 'InvalidRequestException':
            # You provided a parameter value that is not valid for the current state of the resource.
            # Deal with the exception here, and/or rethrow at your discretion.
            raise e
        elif e.response['Error']['Code'] == 'ResourceNotFoundException':
            # We can't find the resource that you asked for.
            # Deal with the exception here, and/or rethrow at your discretion.
            raise e

    secret=""
    if 'SecretString' in get_secret_value_response:
        secret = get_secret_value_response['SecretString']

    # print("In _read_db_password_info, the secret is {}",format(secret),flush=True)
    return secret

def _parse_column_into_list(query_str):
    select_index = query_str.find('select')
    from_index = query_str.find('from')
    print("the select_index is {}, from_index is {}".format(select_index,from_index))
    sub_select_list=[]
    sub_select_list = query_str[select_index+6:from_index].strip().split(",")
    sub_select_list = list(map(lambda s :s.strip(),sub_select_list))
    print("sub_select is {}, len is {}".format(sub_select_list,len(sub_select_list)))
    # for s in sub_select_list:
    #     print("In _parse_into_list sub column is {}".format(s))
    
    return _handle_column_name_list(sub_select_list)


def _handle_column_name_list(column_name_list):
    final_list=[]
    final_list = list(map(_handle_column_name,column_name_list))
    print("in _handle_column_name_list, final column list is {}".format(final_list))
    return final_list

def _handle_column_name(column_name):
    new_column_name = column_name[column_name.find(".")+1:]
    # print("11 the new_column_name is {}".format(new_column_name))

    if new_column_name.find(" as")!=-1 :
        new_column_name = new_column_name[:new_column_name.find(" as")]
    
    # print(("22 the new_column_name is {}".format(new_column_name)))
    return new_column_name


def _check_if_column_allowed(column_name_list,allowed_column_list):
    # return any(substring in column_name for substring in allowed_column_list)
    columns_not_allowed=[]
    for column in column_name_list:
        if any(substring in column for substring in allowed_column_list):
            # print("find allowed column")
            continue
        else:
            print("find not allowed column")
            columns_not_allowed.append(column)
            # return False
    return columns_not_allowed



