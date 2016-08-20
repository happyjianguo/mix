# include <stdio.h>
# include <unistd.h>
# include <errno.h>
# include <stdlib.h>

int main(){
    pid_t pid;
    pid = fork();
    
    if(pid < 0){
        perror("fork error:");
        exit(1);
    }else if (pid == 0){
        printf("I am child process.I am exiting.\n");
        exit(0);
    }
    printf("I am father process.Sleep for 2 seconds\n");
    sleep(2);

    system("ps -o pid,ppid,state,tty,command");
    printf("father process is exiting.\n");
    return 0;
    
}
