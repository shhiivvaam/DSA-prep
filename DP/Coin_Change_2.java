import java.util.*;

public class Coin_Change_2 {
    public static void main(String[] args) {
        int[] coin = { 1, 2, 5 };
        int amount = 5;

        System.out.println(SuperEasySol(amount, coin));

        int[][] dp = new int[amount + 1][coin.length + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1); // since there is a constraint in the ques that the coin array can contains all
                                // the coins as 0 as well
        }

        System.out.println(Coin_Change(coin, amount, 0, dp));
        System.out.println(CoinChnageBU(coin, amount));
    }

    static int SuperEasySol(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        
        return dp[amount];
    }

    static int Coin_Change(int[] coins, int amount, int i, int[][] dp) {

        if (amount == 0)
            return 1; // here we find one answer

        if (i == coins.length)
            return 0;

        if (dp[amount][i] != -1)
            return dp[amount][i];

        int inc = 0; // inclusion
        int exc = 0; // exclusion

        if (amount >= coins[i]) {
            inc = Coin_Change(coins, amount - coins[i], i, dp); // i(index) will be the same, since we have infinite
                                                                // amount //? dp[amount-coin[i]][i]
            // of supply of the coins
            // inc += Coin_Change(coins, amount - coins[i], i + 1); //? dp[amount][i+1]
        }
        exc = Coin_Change(coins, amount, i + 1, dp);
        // exc += Coin_Change(coins, amount, i + 1);

        return dp[amount][i] = inc + exc;
        // dp[amount][i] = inc + exc;
        // return inc + exc;
    }

    static int CoinChnageBU(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int am = 1; am < dp.length; am++) {
            for (int i = 1; i < dp[0].length; i++) {
                int inc = 0;
                int exc = 0;

                if (am >= coins[i - 1]) {
                    inc = dp[am - coins[i - 1]][i];
                }
                exc = dp[am][i - 1];
                dp[am][i] = inc + exc;
            }
        }
        return dp[amount][coins.length];
    }
}