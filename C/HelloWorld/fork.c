# include <stdio.h>
# include <stdlib.h>

int fun1(void){
    printf("hello world.\n");
    return 0;
}

void callback(int (*Pfun)()){
    Pfun();
}

int main(void){
    callback(fun1);
}
