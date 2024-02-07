#include <stdio.h>

int main()
{
	int a,b;
    float c,d;
    
    scanf("%d %d",&a,&b);
    scanf("%f %f",&c,&d);
    
    printf("%d",a+b);
    printf(" ");
    printf("%d\n",a-b);

    printf("%.1f",c+d);
    printf(" ");
    printf("%.1f",c-d);
    
    return 0;
}