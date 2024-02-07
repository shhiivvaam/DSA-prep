import java.util.*;

public class shortSort {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);

        int input = ask.nextInt();
        while(input-- > 0) {
            char c[] = new char[3];
            for (int i = 0; i < 3; i++) {
                c[i] = ask.next().charAt(0);
            }
            if (c[0] == 'a' && c[1] == 'b' && c[2] == 'c')
                System.out.println("NO");
            else {
                if (c[0] == 'a' || c[1] == 'b' || c[2] == 'c')
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}