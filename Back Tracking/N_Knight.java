public class N_Knight {

    static int count = 0;

    static void k_nights(boolean[][] board, int row, int col, String ans, int tn) { // tq -> total knights

        if (tn == 0) {
            System.out.print(ans + " ");
            count++;
            return;
        }

        if (col == board.length) {
            col = 0;
            row++;
        }

        if (row == board.length) {
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;

            k_nights(board, row, col, ans + '{' + row + "-" + col + "} ", tn - 1);
            board[row][col] = false;
        }
        k_nights(board, row, col + 1, ans, tn);

    }

    static boolean isSafe(boolean[][] board, int row, int col) {

        int r[] = { -1, -1, -2, -2 };
        int c[] = { 2, -2, 1, -1 };

        for (int i = 0; i < c.length; i++) {

            int x = row + r[i];
            int y = col + c[i];

            if (x >= 0 && y >= 0 && y < board.length && board[x][y] == true) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 2; // dimensions of the board
        boolean[][] board = new boolean[n][n];

        k_nights(board, 0, 0, "", n);
        System.out.println("\n" + count);
    }

}