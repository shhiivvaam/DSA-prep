
#include<stdio.h>
int main()
{
    int m,n,i,j;
    scanf("%d",&m);
    scanf("%d",&n);
    int A[m][n];
    for(i=1;i<=m;i++)
    {
        for(j=1;j<=n;j++)
            {
                scanf("%d",&A[i][j]);
            }
    }
    for(i=1;i<=m;i++)
    {
        for(j=1;j<=n;j++)
        {
            printf("%d ",A[i][j]);
        }
        printf("\n");
    }
}
