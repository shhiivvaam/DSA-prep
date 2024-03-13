import java.util.*;

public class Distinct_Subsequences {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbbit";

        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1); // since there is a constraint in the ques that the coin array can contains all
                                // the coins as 0 as well
        }
        System.out.println(Distinct_Sub(s, t, 0, 0, dp));
    }

    // This ques has the same logic as the { Coin Change 2 } problem, so going with
    // the same approach
    // coin -> String s, with an index { j }
    // amount -> String t, with an index { i }
    static int Distinct_Sub(String s, String t, int i, int j, int[][] dp) {

        if (i == t.length())
            return 1; // here we find one answer

        if (j == s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int inc = 0; // inclusion
        int exc = 0; // exclusion

        if (s.charAt(j) == t.charAt(i)) {
            inc = Distinct_Sub(s, t, i + 1, j + 1, dp); // i(index) will be the same, since we have infinite
                                                        // amount //? dp[amount-coin[i]][i]
            // of supply of the coins
            // inc += Coin_Change(coins, amount - coins[i], i + 1); //? dp[amount][i+1]
        }
        exc = Distinct_Sub(s, t, i, j + 1, dp);
        // exc += Coin_Change(coins, amount, i + 1);

        return dp[i][j] = inc + exc;
        // dp[amount][i] = inc + exc;
        // return inc + exc;
    }
}
