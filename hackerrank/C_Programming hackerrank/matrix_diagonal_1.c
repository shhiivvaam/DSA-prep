#include <stdio.h>
int main()
{
    int m, n, i, j;
    scanf("%d", &m);
    scanf("%d", &n);
    if (m == n)
    {

        int A[m][n];
        for (i = 1; i <= m; i++)
        {
            for (j = 1; j <= n; j++)
            {
                scanf("%d", &A[i][j]);
                if (i == j)
                    printf("%d ", A[i][j]);
                else
                    printf("  ");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
            }
            printf("\n");
        }
    }
    else
        printf("Not square matrix.");
}