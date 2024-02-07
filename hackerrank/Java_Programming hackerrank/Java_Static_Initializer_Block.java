import java.util.Scanner;
public class Java_Static_Initializer_Block {
    public static void main(String[] args)
    {
        Scanner ask = new Scanner(System.in);

        int breadth = ask.nextInt();
        int height = ask.nextInt();

        if(breadth > 0  && height > 0) {
            System.out.println(breadth*height);
        }
        else {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }
}
