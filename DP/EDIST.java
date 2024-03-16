import java.util.*;

public class EDIST {
    // ! SPOJ -> EDIST (Edit Distance)

    // ? Question
    // You are given two strings, A and B. Answer, what is the smallest number of
    // operations you need to
    // transform A to B?

    // Operations are:

    // Delete one letter from one of strings
    // Insert one letter into one of strings
    // Replace one of letters from one of strings with another letter
    // Input
    // T - number of test cases

    // For each test case:

    // String A
    // String B
    // Both strings will contain only uppercase characters and they won't be longer
    // than 2000 characters.

    // There will be 10 test cases in data set.

    // Output
    // For each test case, one line, minimum number of operations.

    // Example
    // Input:
    // 1
    // FOOD
    // MONEY

    // Output:
    // 4
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int t = ask.nextInt();

        while (t-- > 0) {

            String s1 = ask.next();
            String s2 = ask.next();
            int dp[][] = new int[s1.length()][s2.length()];
            for (int[] arr : dp) {
                Arrays.fill(arr, -1);
            }
            // String s1 = "FOOD";
            // String s2 = "MONKEY";
            System.out.println(editDistance(s1, s2, 0, 0, dp));
            System.out.println(editDistance_BU(s1, s2));
        }

        ask.close();
    }

    static int editDistance(String s1, String s2, int i, int j, int[][] dp) {

        if (i == s1.length())
            return s2.length() - j;
        if (j == s2.length())
            return s1.length() - i;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = editDistance(s1, s2, i + 1, j + 1, dp); // dp[i-1][j-1]
        } else {
            int delete = editDistance(s1, s2, i + 1, j, dp); // dp[i-1][j]
            int insert = editDistance(s1, s2, i, j + 1, dp); // dp[i][j-1]
            int replace = editDistance(s1, s2, i + 1, j + 1, dp); // dp[i-1][j-1]

            ans = Math.min(replace, Math.min(insert, delete)) + 1;
        }
        return dp[i][j] = ans;
    }

    static int editDistance_BU(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int ans = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ans = dp[i - 1][j - 1];
                } else {
                    int delete = dp[i - 1][j];
                    int insert = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];

                    ans = Math.min(replace, Math.min(insert, delete)) + 1;
                }
                dp[i][j] = ans;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
