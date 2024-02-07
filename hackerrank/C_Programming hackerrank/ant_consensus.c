#include <stdio.h>
#include <math.h>

int main()
{
    int C,K,N;

    scanf("%d",&C);
    scanf("%d",&K);
    scanf("%d",&N);

    float t;
    t = C*pow(K,N);

    printf("%.0f",t);
    return 0;
}