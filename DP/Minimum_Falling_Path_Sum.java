import java.util.*;

public class Minimum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

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
            ans = Math.min(ans, minFallingPathSum(grid, 0, i)); // traversing with respect to the column values
            ansDP = Math.min(ansDP, minFallingPathSum_DP(grid, 0, i, dp)); // traversing with respect to the column values
        }
        System.out.println(ans);
        System.out.println(ansDP);
    }

    static int minFallingPathSum(int[][] grid, int i, int j) {

        if (j < 0 || j >= grid[0].length) // firstly, checking the column contraint, ver important
            return Integer.MAX_VALUE;

        if (i == grid.length - 1)
            return grid[i][j];

        int left = minFallingPathSum(grid, i + 1, j - 1); // row+1, col-1
        int right = minFallingPathSum(grid, i + 1, j + 1); // row+1, col+1
        int down = minFallingPathSum(grid, i + 1, j); // row+1, col

        return grid[i][j] + Math.min(down, Math.min(left, right));
    }

    static int minFallingPathSum_DP(int[][] grid, int i, int j, int[][] dp) {

        if (j < 0 || j >= grid[0].length) // firstly, checking the column contraint, ver important
            return Integer.MAX_VALUE;

        if (i == grid.length - 1)
            return grid[i][j];

        if(dp[i][j] != -1 ) return dp[i][j];

        int left = minFallingPathSum_DP(grid, i + 1, j - 1, dp); // row+1, col-1
        int right = minFallingPathSum_DP(grid, i + 1, j + 1, dp); // row+1, col+1
        int down = minFallingPathSum_DP(grid, i + 1, j, dp); // row+1, col

        return dp[i][j] = grid[i][j] + Math.min(down, Math.min(left, right));
    }
}
