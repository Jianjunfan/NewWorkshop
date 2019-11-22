import sqlparse
from sqlparse.sql import IdentifierList, Identifier
from sqlparse.tokens import Keyword, DML
# sql = "select K.a from R.T ;"
# sql = "select K.a from R.T t;"
# sql = "select K.a from T;"
# sql = "select K.a from T t;"
sql = "SELECT * FROM `venusa-rbc`.app_applicant a, `venusa-rbc`.app_application b;"
def is_subselect(parsed111):
    # print("In is_subselect, parsed111 is {}".format(parsed111))
    # print("In is_subselect, parsed111.is_group is {}".format(parsed111.is_group))

    b1=parsed111.is_group
    # if not parsed111.is_group():
    #     return False

    if not b1:
        print("In is_subselect return false")
        return False

    for item in parsed111.tokens:
        if item.ttype is DML and item.value.upper() == 'SELECT':
            return True
    return False

def my_extract_from_part(parsed):
    print("In my_extract_from_part, parsed is {}".format(parsed))
    print("In my_extract_from_part, parsed.tokens is {}".format(parsed.tokens))
    from_seen = False
    for item in parsed.tokens:
        if from_seen:
            if is_subselect(item):
                for x in my_extract_from_part(item):
                    yield x
            else:
                print("my_extract_from_part item is {}".format(item))
                yield item

        elif item.ttype is Keyword and item.value.upper() == 'FROM':
            print("find one FROM")
            from_seen = True

def extract_table_identifiers(token_stream):
    for item in token_stream:
        # print("In extract_table_identifiers, the item is {}".format(item))
        if isinstance(item, IdentifierList):
            for identifier in item.get_identifiers():

                _find_dot = False
                for token_item in identifier.tokens:
                    if token_item.value == '.':
                        _find_dot = True
                        break

                if _find_dot:
                    yield identifier.tokens[2].value
                else:
                    yield identifier.tokens[0].value
                # yield identifier.get_name()
        elif isinstance(item, Identifier):
            # print("In extract_table_identifiers, the item.get_name() is {}".format(item.tokens[0].value))
            # yield item.get_name()
            _find_dot=False
            for token_item in item.tokens:
                if token_item.value=='.':
                    _find_dot = True
                    break

            # _item_is_group = item.tokens[0].is_group
            # if _item_is_group:
            #     yield item.tokens[2].value
            # else:
            #     yield item.tokens[0].value
            if _find_dot:
                yield item.tokens[2].value
            else:
                yield item.tokens[0].value

        # elif item.ttype is Keyword:
        #     yield item.value

def extract_tables():
    print("In extract_tables begin ")
    table_list=[]
    stream = my_extract_from_part(sqlparse.parse(sql)[0])
    for item in extract_table_identifiers(stream):
        print("IN In extract_tables begin table name is {}".format(item))
        table_list.append(item)
    return table_list

# if __name__ == '__main__':
#     list_table = extract_tables()
#     print("the table name list is {}".format(list_table))

