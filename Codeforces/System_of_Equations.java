import java.util.Scanner;

public class System_of_Equations {
    public static void main (String args[]) {
        Scanner ask = new Scanner(System.in);
        
        int n = ask.nextInt();
        int m = ask.nextInt();
        
        int total = n+m;
        int count = 0;
        for(int a = 0;a<total;a++) {
            for(int b = 0;b<total;b++) {
                int first = ((int)Math.pow(a, 2)) + b;
                int second = ((int)Math.pow(b, 2)) + a;
                
                if(first == n && second == m) count++;
            }
        }
        System.out.println(count);
        
        ask.close();
    }
}
