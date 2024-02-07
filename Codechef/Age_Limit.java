/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Age_Limit
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner ask = new Scanner(System.in);
		
		int input = ask.nextInt();
		
		int [] arr = new int [input];
		
		for(int i = 0;i<arr.length;i++) {
		    int one = ask.nextInt();
		    int two = ask.nextInt();
		    int age = ask.nextInt();
		    
		    if(age <= two && age > one) {
		        arr[i] = 1;
		    }
		    else {
		        arr[i] = 0;
		    }
		}
		
		for(int i = 0;i<arr.length;i++) {
		    if(arr[i] == 1) {
		        System.out.println("YES");
		    }
		    else {
		        System.out.println("NO");
		    }
		}
	}
}



// 2



/* package codechef; // don't place package name! */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class cAge_Limit
// {
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 		Scanner ask = new Scanner(System.in);
		
// 		int T = ask.nextInt();
		
// 		int X,Y,A;
		
// 		while(T != 0) {
		    
// 		    X = ask.nextInt();
// 		    Y = ask.nextInt();
// 		    A = ask.nextInt();
		    
// 		    if(A < Y && A >= X) {
// 		        System.out.println("YES");
// 		    }
// 		    else {
// 		        System.out.println("NO");
// 		    }
		    
// 		    T--;
// 	    }
// 	}
// }

