import java.util.*;

public class minimum_number_from_given_Sequence {

    public static void minimum_number(String str) {
        int ans[] = new int[str.length() + 1];
        int count = 1;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == 'I') {
                ans[i] = count;
                count++;
                while (!st.isEmpty()) {
                    ans[st.pop()] = count;
                    count++;
                }
            } else
                st.push(i);
        }

        // printing the answer String
        for (int i = 0; i <= str.length(); i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        String str = "DDIIDIDD";
        minimum_number(str);
    }
}
