import java.util.Scanner;
    public class Java_Loops_I {
    public static void main(String[] args)
    {
        Scanner ask = new Scanner(System.in);
        int input = ask.nextInt();
        
        for(int i = 1;i<=10;i++) {
            int ans = input*i;
            System.out.println(input+" x "+i+" = "+ans);
        }
    }
}
