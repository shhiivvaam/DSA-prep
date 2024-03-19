import java.util.*;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(LIS(arr));
        System.out.println(LIS_NlogN(arr));
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

    // This is the most optimized version of thie Longest Increasing Subsequence Question
    public static int LIS_NlogN(int[] arr) {
        int[] ans = new int[arr.length];
        ans[0] = arr[0];
        int len = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ans[len - 1]) {
                ans[len] = arr[i];
                len++;
            } else {
                int idx = BinarySearch(ans, 0, len - 1, arr[i]);
                ans[idx] = arr[i];
            }
        }
        return len;
    }

    static int BinarySearch(int[] ans, int lo, int hi, int item) {

        int idx = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (ans[mid] >= item) {
                idx = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return idx;
    }
}
