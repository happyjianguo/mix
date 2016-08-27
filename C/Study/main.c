#include <stdio.h>
#include <stdlib.h>

int main() {
    struct student {
        char *username;
        int age;
    };
    typedef struct student STU;
    STU *p = NULL;
    p = (STU *) malloc(sizeof(STU));
    p->username = "fanteathy";
    p->age = 10;
    printf("%s", p->username);
    return 0;
}
