import atexit
import io
import logging

import boto3

def write_logs_s3(body, bucket, key):
    s3 = boto3.client("s3")
    print("in write_logs_s3, body is {}".format(body))
    s3.put_object(Body=body, Bucket=bucket, Key=key)  

def init_logger():
    global log
    log = logging.getLogger("test-sample")
    global log_stringio
    log_stringio = io.StringIO()
    handler = logging.StreamHandler(log_stringio)
    log.addHandler(handler)
    return log

def writer_logger(logger_data):
    log.error(logger_data)
    body = log_stringio.getvalue()
    write_logs_s3(body,"dev-data-dataapi-configurationfiles.snc.com","configurations/omnidb/db.log")


    
