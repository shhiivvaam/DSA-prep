import java.util.Scanner;

public class Java_Int_to_String {

    public static void main(String[] args) {
        
        Scanner ask = new Scanner(System.in);

        int num = ask.nextInt();

        String str = Integer.toString(num);
        
        if(num == Integer.parseInt(str)) {
            System.out.println("Good job");
        }
        else {
            System.out.println("Wrong answer");
        }
    }
}
