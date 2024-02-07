/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Biryani_Classes
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
            arr[i] = one*two;
		}
		
		for(int i = 0;i<arr.length;i++) {
		    System.out.print(arr[i]+"\n");
		}
	}
}
