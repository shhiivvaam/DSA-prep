#include <stdio.h>

int main()
{
    int m,n,i,j;
    printf("enter no. of rows and columns (respectively) : \n");
    int a[m][n];

    scanf("%d %d",&m,&n);

    for(int i=0;i<m;i++);
    {
        for (int j=0;j<n;j++);
        {
            scanf("%d",&a[i][j]);
        }
    }

    return 0;
}   