package Maths;
import java.util.*;

public class gcd{

    // lcm and GCD Relation
    // > lcm(a,b) * gcd(a,b) = a*b

    public static void main(String[] args) {

        // Most Easy and Most Efficient Approach

        // Approach
        // gcd(int a, int b) -> if a number is zero return another number
        //                     -> or else while both the numbers are not equal to each other reduce the greater number with the smaller number annd store in the greater number 

        Scanner ask = new Scanner(System.in);

        int a = ask.nextInt();
        int b = ask.nextInt();

        if(a == 0) System.out.println(b);
        if(b == 0) System.out.println(a);

        while(a != b) {
            if(a>b) a = a-b;
            else b = b-a;
        }

        System.out.println(a);


        ask.close();
        


        // Easiest Efficient And Basic Approach

        // int a = 72;
        // int b = 24;
        // int gcd = 1;
        // for(int i = 1;i<=a && i<=b;i++) {
        //     if(a%i==0 && b%i==0) {
        //         gcd = i;
        //     }
        // }
        // System.out.println(gcd);
        
    }
}