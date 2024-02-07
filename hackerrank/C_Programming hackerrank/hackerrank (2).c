// PRINTING MATRIX

// #include <stdio.h>

// int main()
// {
// int m,n,i,j;

// printf("enter the elements for rows and columns (respectively) : \n");
// scanf("%d %d",&m,&n);

// int a[m][n];

// for(int i=0;i<m;i++)
// {
//     for(int j=0;j<n;j++)
//     {
//         scanf("%d",&a[i][j]);
//     }
// }

//     for(int i=0;i<m;i++)
//     {
//         for(int j=0;j<n;j++)
//         {
//             printf("%d",a[i][j]);
//         }
//         printf("\n");
//     }
//     return 0;
// }

// MATRIX SUM 5

// #include <stdio.h>

// int main()
// {
//     int m, n, i, j,s=0,p=1;
//     printf("enter the elements for rows and columns (respectively) : \n");

//     scanf("%d %d", &m, &n);
//     int a[m][n];

//     for (int i = 0; i < m; i++)
//     {
//         for (int j = 0; j < n; j++)
//         {
//             scanf("%d", &a[i][j]);
//             s = s + a[i][j];
//             p = p*a[i][j];
//         }
//     }

//     printf("%d ",s);
//     printf("%d",p);
//     return 0;
// }

// Row Sum

// #include <stdio.h>

// int main()
// {
//     int m,n,i,j,r;

//     printf("enter the elements for rows and columns (respectively) : \n");
//     scanf("%d %d",&m,&n);

//     int a[m][n];

//     for(int i=0;i<m;i++)
//     {
//         for(int j=0;j<n;j++)
//         {
//             scanf("%d",&a[i][j]);
//         }
//     }

//     for(int i=0;i<m;i++)
//     {
//         r = 0;
//         for(int j=0;j<n;j++)
//         {
//             r = r+a[i][j];
//         }
//         printf("%d ",r);
//     }

//     return 0;
// }

// MATRIX DIAGONAL 1

// #include <stdio.h>
// #include <string.h>
// #include <math.h>
// #include <stdlib.h>

// int main()
// {
//     int m,n;
//     scanf("%d %d",&m,&n);

//     if(m==n)
//     {
//         int a[m][n];

//         for(int i=0;i<m;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 scanf("%d",&a[i][j]);
//             }
//         }
//         for(int i=0;i<m;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 if(i==j)
//                 {
//                     printf("%d",a[i][j]);
//                 }
//                 else
//                 {
//                     printf("  ");
//                 }
//             }
//             printf("\n");
//         }
//     }
//     else
//     {
//         puts("Not square matrix.");
//     }

//     return 0;
// }

// MAX CHOCOLATES 1

// mere bass ki nhi hai

// FIND THE FOLD

// #include <stdio.h>

// int main()
// {
//     int n, t = 0, b = 0, l = 0, r = 0, i, j;
//     scanf("%d", &n);
//     int a[n][n];

//     for (i = 0; i < n; i++)
//     {
//         for (j = 0; j < n; j++)
//         {
//             scanf("%d", &a[i][j]);
//         }
//     }

//     for (i = 0; i < n; i++)
//     {
//         for (j = 0; j < n; j++)
//         {
//             if ((i == 0) && a[i][j] == 0)
//             {
//                 t++;
//             }
//             if ((j == 0) && a[i][j] == 0)
//             {
//                 l++;
//             }
//             if ((i == (n - 1)) && a[i][j] == 0)
//             {
//                 b++;
//             }
//             if ((j == (n - 1)) && a[i][j] == 0)
//             {
//                 r++;
//             }
//         }
//     }

//         if (t == n)
//         {
//             printf("Folded\nTop");
//         }
//         else if (l == n)
//         {
//             printf("Folded\nLeft");
//         }
//         else if (b == n)
//         {
//             printf("Folded\nBottom");
//         }
//         else if (r == n)
//         {
//             printf("Folded\nRight");
//         }
//         else
//         {
//             printf("Not Folded.\n");
//         }
//     return 0;
// }

// Eliminate Vowels

// #include <stdio.h>
// #include <string.h>
// #include <math.h>
// #include <stdlib.h>

// int main()
// {
//     char str[10000];
//     // gets(str);
//     scanf("%[^\n]%*c");

//     for(int i=0;str[i]!='\0';i++)
//     {
//         if(str[i]== 'a' && 'e' && 'i' && 'o' && 'u' && 'A' && 'E' && 'I' && 'O' && 'U')
//         {
//             str[i] = str[i-1];
//         }   
//         else
//         {
//             puts("hello");
//         }
//     }

//     return 0;
// }


// //CAPITALIZE

// #include <stdio.h>
// #include <string.h>
// #include <math.h>
// #include <stdlib.h>
// #define MAX 100

// int main() 
// {
//     char str[MAX]={0};
//     int i;
//     scanf("%[^\n]s",str);
    
//     for(i=0;str[i]!='\0';i++)
//     {
//         if(i==0 && str[0]!=' ')
//         {
//             if((str[i]>='a' && str[i]<='z'))
//                 str[i]=str[i]-32;
//             continue;
//         }
//         if(str[i]==' ' && str[i+1]!=' ')
//         {
//             ++i;
//             if(str[i]>='a' && str[i]<='z')
//             {
//                 str[i]=str[i]-32;
//                 continue;
//             }
//         }
//         else
//         {
//             if(str[i]='A' && str[i]<='Z')
//                 str[i]=str[i]+32;
//         }
//     }
//     printf("%s",str);
    

//     /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
//     return 0;
// }

//ELIMINATE VOWELS

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    
    return 0;
}