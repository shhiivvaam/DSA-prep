#include <stdio.h>

int main()
{
    int C,N,D;

    scanf("%d",&C);
    scanf("%d",&N);
    scanf("%d",&D);

    int t;
    t = (C*D)+C-N;

    printf("%d",t);

    return 0;
}