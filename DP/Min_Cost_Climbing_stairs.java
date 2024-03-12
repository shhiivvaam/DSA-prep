import java.util.*;

public class Min_Cost_Climbing_stairs {
    public static void main(String[] args) {
        int arr[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(minCost(arr, 0, dp));
        System.out.println(minCostBU(arr));
    }

    // Top Down Approach
    static int helper(int[] arr, int[] dp) {
        int one_index = minCost(arr, 0, dp);
        int two_index = minCost(arr, 1, dp);

        return Math.min(one_index, two_index);
    }

    static int minCost(int[] arr, int i, int[] dp) {
        if (i >= arr.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int one_step = minCost(arr, i + 1, dp);
        int two_step = minCost(arr, i + 2, dp);

        dp[i] = Math.min(one_step, two_step) + arr[i];
        return Math.min(one_step, two_step) + arr[i];
    }

    // Bottom Up Approach
    static int minCostBU(int[] arr) {

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1];

        for(int i = 2;i<arr.length;i++) {
            int one_step_back = dp[i-1];
            int two_step_back = dp[i-2];

            dp[i] = Math.min(one_step_back, two_step_back) + arr[i];
        }
        return Math.min(dp[arr.length-1], dp[arr.length-2]);
    }
}
