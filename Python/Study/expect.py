#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""使用expect批量登陆服务器,防止每次登陆时都需要讯问Are you sure you want to continue connecting (yes/no)?"""

import sys
import re
import os
import stat

ROOT_DIR = "/Users/joshua/Documents/work/灾备/disaster_machines/"
EXPECTED_ARGV = ['async', 'sync', 'tob']

def write_common_expect(file_handler):
    file_handler.write('expect {\n')
    file_handler.write('"(yes/no)? " {\n')
    file_handler.write(r'	send "yes\r"' + "\n")
    file_handler.write('	expect "$ "\n')
    file_handler.write(r'	send "exit\r"' + "\n")
    file_handler.write('}\n')
    file_handler.write('"$ " {\n')
    file_handler.write(r'	send "exit\r"' + "\n")
    file_handler.write('}\n')
    file_handler.write('timeout {\n')
    file_handler.write('	exit\n')
    file_handler.write('}\n')
    file_handler.write('eof {\n')
    file_handler.write('	exit\n')
    file_handler.write('}\n')
    file_handler.write('}\n')


def main():
    app_id = sys.argv[1]
    if not app_id in EXPECTED_ARGV:
        exit("wrong app_id")

    sh_file = ROOT_DIR + sys.argv[1] + "_login.sh"
    sh_file_handler = open(sh_file, "w+")
    sh_file_handler.write("#!/usr/bin/expect\n")
    sh_file_handler.write("set timeout 5\n")
    filename = ROOT_DIR + sys.argv[1]
    pattern = re.compile(r'[\w.]+@(.*)')
    with open(filename) as f:
        for line in f.readlines():
            match = pattern.match(line)
            hostname = match.group(1)
            sh_file_handler.write("spawn ssh -l zhihua.he " + hostname + "\n")
            write_common_expect(sh_file_handler)

    sh_file_handler.write("interact\n")
    sh_file_handler.close()
    os.chmod(sh_file, stat.S_IRWXU)


if __name__ == "__main__":
    main()
