import java.util.Scanner;

public class Serval_and_Inversion_Magic {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int c = 0;
            String s = in.next();
            for (int i = 0; i < (int) Math.floor(n / 2); i++) {
                if (((s.charAt(i)) != s.charAt(n - i - 1))) {
                    while (i < n / 2 && s.charAt(i) != s.charAt(n - i - 1)) i++;
                    c++;
                }
            }
            if (c > 1) {
                System.out.println("NO");
            } else System.out.println("YES");
        }
        in.close();
    }
}