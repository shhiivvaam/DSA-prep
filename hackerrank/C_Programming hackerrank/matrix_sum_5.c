#include <stdio.h>

int main()

{

    int m, n, i, j, s = 0, x = 1;

    scanf("%d", &m);

    scanf("%d", &n);

    int A[m][n];

    for (i = 1; i <= m; i++)

    {

        for (j = 1; j <= n; j++)

        {

            scanf("%d", &A[i][j]);

            s = s + A[i][j];

            x = x * A[i][j];
        }
    }

    printf("%d ", s);

    printf("%d", x);
}