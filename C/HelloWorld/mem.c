#include<stdio.h>
#include<stdlib.h>
int main(){
	int StudentNum;                     //记录班级人数
	int Score=0;                          //记录平均成绩
	int * p;                            //定义一个int行指针
	printf("请输入班级人数:\n");
	scanf("%d",&StudentNum);
	p=(int *)malloc(StudentNum * sizeof(int));   //开辟StudentNum个int空间

	printf("请输入%d个同学成绩:\n",StudentNum);
	for(int i=0;i<StudentNum;i++){
		scanf("%d",&p[i]);
	}
	printf("该班级全部成绩为:\n");
	for(i=0;i<StudentNum;i++){
		printf("%d\n",p[i]);
		Score=Score+p[i];
	}
	Score=Score/StudentNum;                  //计算平均成绩
	printf("该班级平均成绩为%d\n",Score);
	free(p);
	return 0;
}
