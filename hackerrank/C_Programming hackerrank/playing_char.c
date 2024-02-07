#include <stdio.h>

int main()
{
    char c;
    scanf("%c",&c);
    printf("%c\n",c);

    char s[20];
    scanf("%s",&s);
    printf("%s\n",s);

    scanf("\n");

    char l[100];
    scanf("%[^\n]s",l);
    printf("%s",l);

    return 0;
}