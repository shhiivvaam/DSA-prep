#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char s[10000],ch;
    int i,c=0;
    scanf("%[^\n]%*c",s);
    scanf("%c",&ch);
    for(i=0;s[i]!='\0';i++)
    { 
    if(s[i]==ch)
            c++;
    }
printf("%d",c);
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    return 0;
}