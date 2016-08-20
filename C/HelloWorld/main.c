# include <stdio.h>
# include <mm_malloc.h>

struct Student{
    char name[100];
    int age;
    float score;
};

int main(void){
    int len;
    struct Student * pArr;
    int i, j;
    struct Student t;

    printf("Please input number of student:\n");
    printf("len = ");
    scanf("%d", &len);
    pArr = (struct Student *)malloc(len * sizeof(struct Student));

    for(i=0; i<len; i++){
        printf("Please input the %d student info:\n", i+1);
        printf("name = ");
        scanf("%s", pArr[i].name);
        printf("age = ");
        scanf("%d", &pArr[i].age);
        printf("score = ");
        scanf("%f", &pArr[i].score);
    }

    for(i=0; i<len; i++){
        printf("The %d student's info:\n", i+1);
        printf("name = %s\n", pArr[i].name);
        printf("age = %d\n", pArr[i].age);
        printf("score = %f\n", pArr[i].score);
        printf("\n");
    }

    return 0;
}
