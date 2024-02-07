#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char s[1000];
    int i,up=0,lo=0,sp=0;
    scanf("%[^\n]",s);
    for(i=0;s[i]!='\0';i++)
    {
        if(s[i]>='A'&&s[i]<='Z')
            up++;
        else if(s[i]>='a'&&s[i]<='z')
            lo++;
        else
            sp++;
    }
    printf("%d\n%d\n%d\n",up,lo,sp);
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    return 0;
}