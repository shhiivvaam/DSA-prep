#include <stdio.h>
#include <math.h>

int main()
{
    float P,R;

    scanf("%f",&P);
    scanf("%f",&R);

    float c;
    c = P*(pow(1+R/100,2))-P;

    printf("%.2f",c);
    return 0;
}