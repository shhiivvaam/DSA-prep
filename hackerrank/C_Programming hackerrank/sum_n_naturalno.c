#include <stdio.h>

int main()
{
    int i=1,n,s=0;
    scanf("%d",&n);

    while(i<=n)
    {
        s = s+n;
        n++;
        printf("%d",n);
    }
    return 0;
}   