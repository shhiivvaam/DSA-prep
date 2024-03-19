import java.util.*;

public class Minimum_Falling_Path_Sum_II {
    public static void main(String[] args) {
        // int[][] grid = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9} };

        int[][] dp = new int[grid.length][grid[0].length]; // since its a square matrix, you can choose any of the
                                                           // dimensions for the dp
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // Starting the traversal from the first column and then proceeding to the last
        // to find the path(ans)
        int ans = Integer.MAX_VALUE;
        int ansDP = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, minFallingPathSumII(grid, 0, i)); // traversing with respect to the column values
            ansDP = Math.min(ansDP, minFallingPathSumII_DP(grid, 0, i, dp)); // traversing with respect to the column values
        }
        System.out.println(ans);
        System.out.println(ansDP);
    }

    static int minFallingPathSumII(int[][] grid, int row, int col) {

        if (col < 0 || col >= grid[0].length) // firstly, checking the column contraint, very important
            return Integer.MAX_VALUE;

        if (row == grid.length - 1)
            return grid[row][col];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            if (i != col)
                ans = Math.min(ans, minFallingPathSumII(grid, row + 1, i)); // traversing with respect to the column
                                                                            // values
        }

        return grid[row][col] + ans;
    }

    static int minFallingPathSumII_DP(int[][] grid, int row, int col, int[][] dp) {

        if (col < 0 || col >= grid[0].length) // firstly, checking the column contraint, very important
            return Integer.MAX_VALUE;

        if (row == grid.length - 1)
            return grid[row][col];

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            if (i != col)
                ans = Math.min(ans, minFallingPathSumII_DP(grid, row + 1, i, dp)); // traversing with respect to the column
                                                                            // values
        }

        return dp[row][col] = grid[row][col] + ans;
    }

}
