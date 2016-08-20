# include <stdio.h>

union data{
    int i;
    char c;
} a;

int main(void){
    a.i = 3;
    a.c = 'A';
    printf("%d\n", a.i);
    printf("address is %p, %p", &a.i, &a.c);

    return 0;
}
