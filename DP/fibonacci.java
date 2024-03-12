public class fibonacci {

    // * Using Recursion
    static int fibo(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    // * Top Down Approach
    static int fiboTD(int n, int[] dp) {
        if (n == 0 || n == 1)
            return n;

        if (dp[n] != 0) // dp apply kia ho
            return dp[n];

        int f1 = fiboTD(n - 1, dp);
        int f2 = fiboTD(n - 2, dp);

        dp[n] = f1 + f2; // yadd kia ho
        // return dp[n];
        return f1 + f2;
    }

    // * Bottom Up Approach
    static int fiboBU(int n) {
        // at first we will remember all the base case in the dp Array
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 45;
        // System.out.println(fibo(n));

        int[] dp = new int[n + 1]; // indexing 0 to n == length -> n + 1
        System.out.println(fiboTD(n, dp));
        System.out.println(fiboBU(n));
    }
}