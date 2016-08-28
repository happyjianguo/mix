#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main(){
    printf("Test\n");
    pid_t pid;
    pid = fork();
    if(pid < 0){
        printf("fork error!\n");
        exit(1);
    }

    if(pid == 0){
        printf("child process ! PID: %d\n", getpid());
    } else{
        printf("parent process ! PID: %d\n", getpid());
    }

    return 0;
}

