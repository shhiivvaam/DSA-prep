#include <stdio.h>

int main()
{
    int P;
    int R;
    int T;

    printf("enter the values of p,r,t respectively : \n");
    scanf("%d",&P);
    scanf("%d",&R);
    scanf("%d",&T);

    int si;
    si = ((P*R*T)/100) + P;

    printf("%d",si);

    return 0;
}