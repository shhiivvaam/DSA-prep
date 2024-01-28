public class N_Queen {

    static void n_queens_all_possible_paths(boolean[][] board, int row, int tq) { // tq > total queens

        if (tq == 0) {
            display(board);
            return;
        }

        if (row == board.length) {
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isPossible(board, row, col) == true) {
                board[row][col] = true;
                n_queens_all_possible_paths(board, row + 1, tq - 1);
                board[row][col] = false;
            }
        }
    }

    static boolean isPossible(boolean[][] board, int row, int col) {

        // upper direction
        int r = row;
        while (r >= 0) {
            if (board[r][col] == true) {
                return false;
            }
            r--;
        }

        // left upper diagonal
        int c = col;
        r = row;
        while (c >= 0 && r >= 0) {
            if (board[r][c] == true) {
                return false;
            }
            c--;
            r--;
        }

        // right upper diagonal
        c = col;
        r = row;
        while (c < board[0].length && r >= 0) {
            if (board[r][c] == true) {
                return false;
            }
            c++;
            r--;
        }

        return true;
    }

    static void display(boolean[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        n_queens_all_possible_paths(board, 0, n); // board, current row, total queens
    }
}
