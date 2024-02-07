// #include <stdio.h>

// int main() 
// {
//     // int a, b, c, d;
//     // scanf("%d %d %d %d", &a, &b, &c, &d);
//     // int e = (a, b);
//     // int f = (c, d);
    
//     // int g;
//     // g = max(e,f);

//     // // int g = (e, f);

//     // printf("%d", g);
//     scanf("%d %d %d %d",&a,&b,&c,&d);

//     int sum(int a, int b,int c, int d){
//     int sum = 0;
//     sum += a;
//     sum += b;
//     sum += c;
//     sum += d;
//     return sum;
//     }
    
//     return 0;
// }

#include <stdio.h>

int max(int a, int b, int c, int d)
{
    int max;
    max = a>b?a:b;
    max = c>max?c:max;
    max = d>max?d:max;
    return max;
}

int main()
{
    int a,b,c,d;
    scanf("%d %d %d %d",&a,&b,&c,&d);
    int ans = max(a,b,c,d);
    printf("%d",ans);

    return 0;
}