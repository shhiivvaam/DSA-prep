import java.util.Scanner;

public class Java_Stdin_and_Stdout_II {
    public static void main(String[] args)
    {
        Scanner ask = new Scanner(System.in);

        int i = ask.nextInt();
        double d = ask.nextDouble();
        ask.nextLine();
        String s = ask.nextLine();


        System.out.println("String: "+s);
        System.out.println("Double: "+d);
        System.out.println("Int: "+i);
    }
}
