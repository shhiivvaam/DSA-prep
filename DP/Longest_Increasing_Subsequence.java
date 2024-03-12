import java.util.*;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(LIS(arr));
    }

    // This will have the Complexity of O(n^2)
    // This is the naive approach to solve the problem.
    // We will use the concept of both the Binary Search and Dynaminc Programming to
    // solve this problem.

    static int LIS(int[] arr) {

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1); // every element will itself have the longest subsequence of one

        // starting the traversal from { 1st index } -> since the 0th indexed element
        // will have the longest subsequence of { 1 } only
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp[j] + 1 : to include the current element count for the
                                                        // longest increasing subsequence
                }
            }
        }

        // now performing the binary serach to find the max length from the dp array
        // the logic is to find the max element only

        int ans = 1; // min one longest subsequence for the current element will always be be there
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > ans)
                ans = dp[i];
        }
        return ans;
    }
}
