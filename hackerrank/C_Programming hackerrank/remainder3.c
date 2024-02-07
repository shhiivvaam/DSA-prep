#include <stdio.h>

int main()
{
    int a,b;
    scanf("%d %d",&a,&b);

    // (num - divisor * (num / divisor))

    int r = (a-(a/b)*b);
    printf("%d",r);
    return 0;
}


