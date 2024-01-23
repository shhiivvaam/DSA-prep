import java.util.*;

public class substrings {

    static void printSubstring(String str) {
        for(int i = 1;i<=str.length();i++) {
            for(int j = 0;j<=str.length()-i;j++) {
                int end = i + j;
                System.out.println(str.substring(j, end));
            }
        }
    }
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        String str = ask.next();

        printSubstring(str);

        ask.close();
    }
}
