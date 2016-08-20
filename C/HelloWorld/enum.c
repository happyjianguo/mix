# include <stdio.h>

enum WeekDay{
    Monday, Tuesday, Wednesday
};

int main(void){
    enum WeekDay day1, day2;

    day1 = Monday;
    day2 = Tuesday;
    printf("Monday = %d\n", day1);
    printf("Tuesday = %d\n", day2);

    return 0;
}
