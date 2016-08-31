#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""使用存储于~/Downloads/task_hashes中的task_hash将eos_mysql_task表中对应task_hash的task status置为2"""

sql = ""
with open("/Users/joshua/Downloads/task_hashes") as f:
    for line in f.readlines():
        task_hash = line.strip()
        sql += 'update eos_mysql_task set status = 2 where task_hash = "' + task_hash + '";'
        sql += 'commit;'

file_output = "/Users/joshua/Downloads/sql.sql"
output_handler = open(file_output, "w")
output_handler.write(sql)
output_handler.close()
