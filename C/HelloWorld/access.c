# include <unistd.h>
# include <stdio.h>
int main(){
    if(access("/etc/passwd", R_OK) == 0){
        printf("Access Accepted\n");
    }
    return 0;
}
