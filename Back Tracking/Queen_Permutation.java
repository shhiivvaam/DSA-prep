public class Queen_Permutation {

    // ! Question:
    // ? Given a 1D board of size 4, place given 2 queens in permutation
    // * the answer will be in the format : the placement of the queen with the
    // current position of the board (with queen) */

    static void Queen(boolean[] board, int tq, int tqp, String ans) {

        // tq -> total given queens
        // tqp -> total queens placed
        // ans -> String to print the queen places after calculating

        if (tq == tqp) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i] == false) {
                board[i] = true;

                Queen(board, tq, tqp + 1, ans + "b" + i + "q" + tqp + " ");
                board[i] = false;
            }
        }

    }

    public static void main(String[] args) {

        boolean[] board = new boolean[4]; // This is to keep track of the places where we have placed the queen, and
                                          // should not be placed again
        int n = 2; // number of queens

        Queen(board, n, 0, "");
    }
}
