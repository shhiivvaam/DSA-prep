public class Suduko_Solver {

    static void suduko_solver(int[][] grid, int row, int col) {

        if (col == 9) {
            row += 1;
            col = 0;
        }

        if (row == 9) {
            display(grid);
            return;
        }

        if (grid[row][col] != 0) {
            suduko_solver(grid, row, col + 1);
        } else {
            for (int val = 1; val <= 9; val++) {
                // Check the validity of 'val' to place at grid[row][col]
                if (isPossible(grid, row, col, val) == true) {

                    grid[row][col] = val;
                    suduko_solver(grid, row, col + 1);
                    grid[row][col] = 0; // backtrak step
                }
            }
        }
    }

    static boolean isPossible(int[][] grid, int row, int col, int val) {

        // checking the current row
        int c = 0;
        while (c < 9) {
            if (grid[row][c] == val) {
                return false;
            }
            c++;
        }

        // checking the current column
        int r = 0;
        while (r < 9) {
            if (grid[r][col] == val) {
                return false;
            }
            r++;
        }

        // checking the current 3x3 block { matrix }
        r = row - row % 3;
        c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grid[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    static void display(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 },
        };

        suduko_solver(grid, 0, 0);
    }
}
