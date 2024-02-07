#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char s[1000],c;
    int i,len;
    scanf("%[^\n]",s);
    len = strlen(s);
    if (len%2==0)
    {
        for(i=0;i<len;i+=2)
        {
            c = s[i];
            s[i]=s[i+1];
            s[i+1]=c;
        }
        printf("%s",s);
    }
    else
    {
        printf("Odd length.");
    }

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    return 0;
}
