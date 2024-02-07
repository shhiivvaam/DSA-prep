#include <stdio.h>
int main()
{

    int n;
    scanf("%d", &n);
    int a[n][n], top = 0, bottom = 0, right = 0, left = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (j == 0 && a[i][j] == 0)
                left++;
            if (j == n - 1 && a[i][j] == 0)
                right++;
            if (i == 0 && a[i][j] == 0)
                top++;
            if (i == n - 1 && a[i][j] == 0)
                bottom++;
        }
    }
    if (left == n)
        printf("Folded\nLeft");
    else if (right == n)
        printf("Folded\nRight");
    else if (top == n)
        printf("Folded\nTop");
    else if (bottom == n)
        printf("Folded\nBottom");
    else
        printf("Not Folded\n ");

    return 0;
}