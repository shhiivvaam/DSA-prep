import java.util.Scanner;

public class Java_End_of_File {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner ask = new Scanner(System.in);
        
        int temp = 1;

        while(ask.hasNext()) {
            String str = ask.nextLine();
            System.out.println(temp + " " + str);
            temp++;
        }
    }
}
