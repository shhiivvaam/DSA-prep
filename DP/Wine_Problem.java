public class Wine_Problem {
    public static void main(String[] args) {
        int[] wine = { 2, 3, 5, 1, 4 };
        int[][] dp = new int[wine.length][wine.length];

        System.out.println(maxProfit(wine, 0, wine.length - 1, 1));
        System.out.println(maxProfitDP(wine, 0, wine.length - 1, 1, dp));
    }

    static int maxProfit(int[] wine, int i, int j, int year) {

        if (i > j)
            return 0;

        int first = wine[i] * year + maxProfit(wine, i + 1, j, year + 1);
        int second = wine[j] * year + maxProfit(wine, i, j - 1, year + 1);

        return Math.max(first, second);

        // ? my Logic -> Recursion
        // if (i > j)
        // return 0;

        // int ans = 0;
        // if (wine[i] < wine[j])
        // ans = wine[i] * year + maxProfit(wine, i + 1, j, year + 1);
        // else
        // ans = wine[j] * year + maxProfit(wine, i, j - 1, year + 1);

        // return ans;
    }

    static int maxProfitDP(int[] wine, int i, int j, int year, int[][] dp) {

        if (i > j)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        int first = (wine[i] * year) + maxProfit(wine, i + 1, j, year + 1);
        int second = (wine[j] * year) + maxProfit(wine, i, j - 1, year + 1);

        return dp[i][j] = Math.max(first, second);

        // ? my Logic
        // if (i > j)
        // return 0;

        // if (dp[i][j] != 0)
        // return dp[i][j];

        // int ans = 0;
        // if (wine[i] < wine[j])
        // ans = wine[i] * year + maxProfit(wine, i + 1, j, year + 1);
        // else
        // ans = wine[j] * year + maxProfit(wine, i, j - 1, year + 1);

        // return dp[i][j] = ans;
    }

    static int maxProfitDP_BU(int[] wine) {
        int dp[][] = new int[wine.length][wine.length];
        int year = wine.length;
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = wine[i] * year; // filling the diagonal values of the matrix
        }
        year--; // since we have filled the diagonal values

        for (int slide = 1; slide < dp.length; slide++) {
            for (int j = slide; j < dp.length; j++) {
                int i = j - slide;

                int first = wine[i] * year + dp[i + 1][j];
                int second = wine[j] * year + dp[i][j - 1];
                dp[i][j] = Math.max(first, second);
            }
            year--;
        }
        return dp[0][wine.length - 1];
    }
}