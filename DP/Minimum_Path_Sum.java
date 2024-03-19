import java.util.*;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        System.out.println(minPathSum(grid, 0, 0));
        System.out.println(minPathSum_DP(grid, 0, 0, dp));
    }

    static int minPathSum(int[][] grid, int i, int j) {

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j]; // base case: we are at the end of the grid, so return the grid current value at
                               // index grid[i][j]

        if (i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE; // out of bound

        int vertical = minPathSum(grid, i + 1, j);
        int horizontal = minPathSum(grid, i, j + 1);
        return grid[i][j] + Math.min(vertical, horizontal);
    }

    static int minPathSum_DP(int[][] grid, int i, int j, int[][] dp) {

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j]; // base case: we are at the end of the grid, so return the grid current value at
                               // index grid[i][j]

        if (i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE; // out of bound

        if (dp[i][j] != -1)
            return dp[i][j];

        int vertical = minPathSum_DP(grid, i + 1, j, dp);
        int horizontal = minPathSum_DP(grid, i, j + 1, dp);
        return dp[i][j] = grid[i][j] + Math.min(vertical, horizontal);
    }
}
