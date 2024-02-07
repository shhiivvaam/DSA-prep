#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    long long int T,N,f,j;
    scanf("%lld",&T);
    while(T--)
    {
        f=0;
        scanf("%lld",&N);
        for(j=2;j<=sqrt(N);j++)
        {
            if(N%j==0)
            {
                printf("%lld\n",N/j);
                f=1;
                break;
            }
        }
        if(f==0)
            printf("%lld\n",N);
        
    }
    return 0;
}   