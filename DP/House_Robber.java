import java.util.*;

public class House_Robber {
    public static void main(String[] args) {
        int arr[] = { 5, 2, 1, 11 };
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(Robber(arr, 0, dp));
        System.out.println(RobberBU(arr));
    }

    // This is a Top Down Approach
    static int Robber(int[] arr, int index, int[] dp) {
        if (index >= arr.length)
            return 0;

        if (dp[index] != -1)
            return dp[index]; // we have filled the array with { -1 } and also checked with the { -1 } because
                              // there is a constraint given in the index, ie., 0 <= nums.length <= 400 :
                              // which means that there is a possibility that the array can contains all th
                              // elements with value 0

        int rob = arr[index] + Robber(arr, index + 2, dp);
        int not_rob = Robber(arr, index + 1, dp);

        dp[index] = Math.max(rob, not_rob);
        return Math.max(rob, not_rob);
    }

    // This is a Bottom Up Approach -> Iterative Approach
    // here we will assume that the robberry starts from the last house { last
    // element in the array }
    static int RobberBU(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int rob = arr[i] + dp[i - 2];
            int not_rob = dp[i - 1];
            dp[i] = Math.max(rob, not_rob);
        }
        return dp[arr.length - 1];
    }
}
