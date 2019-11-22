import re
import os
from recursive.my_yield import generate_num
from recursive.my_yield import generate_fibonacci
from recursive.my_yield import generate_fibonacci_yield
from recursive.my_yield import A001511
from logger.my_logger import writer_logger
from logger.my_logger import init_logger
from sql_parser.my_sql_parse import extract_tables

import pdb
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


def _main():
    print("begin main funtion")
    # Test1 - have some column not allowed to query
    # query_str = """  select first_name      ,t.last_name as last_name\n,middle_name from d from1 """

    #Test 2 - All allowed
    # query_str = """  select first_name,t.ssn as last_name from d from1 """

    #Test 3 - select all, so continue
    query_str = """  select * from d from1 """

    sub_select_list = _parse_column_into_list(query_str.lower())

    allowed_column_list=["first_name","ssn","phone_number"]
    
    colums_not_allowed = _check_if_column_allowed(sub_select_list,allowed_column_list)
    if len(colums_not_allowed) == 0:
        print("all column in query are allowed")
    elif len(colums_not_allowed) == 1 and colums_not_allowed[0]=='*':
        print("Select all, ignore it and continue")

    else:
        print("found columns in query string are not allowed: {}".format(colums_not_allowed))

    env = os.environ.get('Env')
    print("the $Env is {}".format(env))
    bucket_name = 'hello'
    bucket_name = env + '-' + bucket_name
    print("bucket_name is {}".format(bucket_name))
    # column_name_list=["t.last_name as name", "t.first_name", "ssn"]
    # _handle_column_name_list(column_name_list)

    for index in generate_num(0):
        print("generate_num: the index is {}".format(index))

    # generate_fibonacci_yield(7)
    n=0
    # pdb.set_trace()
    for y in A001511():
        print("In my_yield y is {}".format(y))
        n=n+1
        if n>60:
            break

    # log = get_logger()
    # log.error("test error")
    # init_logger()
    # writer_logger("test error new")
    # writer_logger("test error new11111")

    list_table = extract_tables()
    print("the table name list is {}".format(list_table))

if __name__ == '__main__':
    _main()
