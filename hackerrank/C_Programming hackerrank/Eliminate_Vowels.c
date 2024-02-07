#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char v[10000],c[10000],s[10000];
    int i,j,k;
    scanf("%[^\n]",s);
    for(i=0,j=0,k=0;s[i]!='\0';i++)
    {
        if(s[i]=='A'||s[i]=='E'||s[i]=='I'||s[i]=='O'||s[i]=='U'||s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u')
        {
            v[j++]=s[i];
        }
        else
            c[k++]=s[i];
    }
    puts(c);
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    return 0;
}