import java.util.*;

public class lcs_longest_common_subsequences {
    public static void main(String[] args) {
        String one = "abcde";
        String two = "ace";

        // Scanner ask = new Scanner(System.in);
        // String one = ask.nextLine();
        // String two = ask.nextLine();

        int dp[][] = new int[one.length()][two.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        System.out.println(lcs(one, two, 0, 0)); // This is with normal recursion
        System.out.println(lcs_DP_TD(one, two, 0, 0, dp)); // Applying DP
        System.out.println(lcs_DP_BU(one, two)); // Applying DP

        // ask.close();
    }

    static int lcs(String one, String two, int i, int j) {

        if (i == one.length() || j == two.length())
            return 0;

        int ans = 0;
        if (one.charAt(i) == two.charAt(j)) {
            ans = 1 + lcs(one, two, i + 1, j + 1);
        } else {
            int first = lcs(one, two, i + 1, j);
            int second = lcs(one, two, i, j + 1);
            ans = Math.max(first, second);
        }

        return ans;
    }

    static int lcs_DP_TD(String one, String two, int i, int j, int[][] dp) {

        if (i == one.length() || j == two.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;
        if (one.charAt(i) == two.charAt(j)) {
            ans = 1 + lcs_DP_TD(one, two, i + 1, j + 1, dp);
        } else {
            int first = lcs_DP_TD(one, two, i + 1, j, dp);
            int second = lcs_DP_TD(one, two, i, j + 1, dp);
            ans = Math.max(first, second);
        }
        return dp[i][j] = ans; // Storing the value in the DP table(matrix)
    }

    static int lcs_DP_BU(String one, String two) {
        // This is the Bottom Up Approach of DP. This is more efficient than Top Down
        // Approach.

        int[][] dp = new int[one.length() + 1][two.length() + 1];

        // for (int i = one.length() - 1; i >= 0; i--) {
        // for (int j = two.length() - 1; j >= 0; j--) {
        // int ans = 0;
        // if (one.charAt(i) == two.charAt(j)) {
        // ans = 1 + dp[i + 1][j + 1];
        // } else {
        // int first = dp[i + 1][j];
        // int second = dp[i][j + 1];
        // ans = Math.max(first, second);
        // }
        // dp[i][j] = ans;
        // }
        // }
        // return dp[0][0];

        // ? OR

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int ans = 0;
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    ans = 1 + dp[i - 1][j - 1];
                } else {
                    int first = dp[i - 1][j];
                    int second = dp[i][j - 1];
                    ans = Math.max(first, second);
                }
                dp[i][j] = ans;
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}