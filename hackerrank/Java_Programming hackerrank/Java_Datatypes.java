import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Java_Datatypes{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner ask = new Scanner(System.in);
        
        int t = ask.nextInt();
        
        for(int i = 0;i<t;i++) {
            try {

                long n = ask.nextLong();
                System.out.println(n+" can be fitted in:");

                if(n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }

                if(n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }

                if(n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                
                if(n >= Long.MIN_VALUE && n <= Long.MAX_VALUE) {
                    System.out.println("* long");
                }

            }
            catch (Exception e) {
                System.out.println(ask.next()+" can't be fitted anywhere.");
            }
        }
    }
}
