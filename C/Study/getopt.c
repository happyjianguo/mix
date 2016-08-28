#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    printf("argc: %d\r\n", argc);
    printf("argv: %s argv1:%s argv2: %s argv3: %s\r\n\r\n", argv[0], argv[1], argv[2], argv[3]);

    int oc;
    char ec;

    while ((oc = getopt(argc, argv, "p:n::c")) != -1) {
        printf("optind:%d\r\n", optind); //参数索引值
        printf("optarg:%s\r\n", optarg); //参数值
        switch (oc) {
            case 'p':
                printf("Port: %s\n\n", optarg);
                break;
            case 'n': //参数n  需要-n10 这样使用
                printf("Thread Num:%s\n\n", optarg);
                break;
            case 'c': //参数c，需要-c使用，不用带参数
                printf("This is c\n\n");
                break;
            case '?': //如果设置了未定义的参数，则返回这边的错误信息
                ec = (char) optopt;
                printf("未定义的参数:%c\r\n", ec);
                break;

            case ':': //缺少选项
                printf("缺少选项参数\r\n");
                break;
        }
    }
    return 0;
}

