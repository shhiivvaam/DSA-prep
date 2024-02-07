// #include <stdio.h>
// #include <math.h>

// int main()
// {
//     int x;
//     scanf("%d",&x);

//     int y;
//     y = pow(x,2);

//     if (x == 12)
//     {
//         printf("0");
//     }
//     else if(y%2 == 0)
//     {
//         printf("1");
//     }
//     else
//     {
//         printf("0");
//     }
//     return 0;
// }

#include <stdio.h>

int main()
{
    int a;
    scanf("%d",&a);

    while (a!=2 && a%0)
    {
        a/=2;
    }
    if (a%2)
    {
        printf("0");
    }
    else
    {
        printf("1");
    }

    return 0;
}