public class Uncorssed_Lines {

    //! This problem is same as the LCS(longest common subsequence)
    //? this has exactly the same approach as the LCS probelem, just the language of the problem has been changed.
    public static void main(String[] args) {
        int one[] = { 1, 4, 2 };
        int two[] = { 1, 2, 4 };

        //? here we have used the BU(Buttom Up approach of DP of the problem LCS(longest common subsequence))
        System.out.println(uncrossed_lines(one, two));
    }

    static int uncrossed_lines(int[] one, int[] two) {
        int dp[][] = new int[one.length + 1][two.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int ans = 0;
                if (one[i - 1] == two[j - 1]) {
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
