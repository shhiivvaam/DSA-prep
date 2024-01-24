public class Maze_Path {

    // ! Question:
    // ? We have to find the total number of paths exists int a 2D matrix starting
    // from (0, 0) if we move in { horizontal and vertical } directions only.

    // er -> end row
    // er -> end col
    // er -> current row
    // er -> current col
    // str -> for answer
    static void print_Path(int er, int ec, int cr, int cc, String str) {
        if (cr == er && cc == ec) {                // return the string { str } which contains the path of the matrix took to reach the final destination { n-1 , m-1} or the er/ec { end row and end col } position
            System.out.print(str + " ");
            return;
        }

        if (cr > er || cc > ec) {                 // base case: when the current row/current col becomes greater than the end row/ end col respectively
            return;
        }

        print_Path(er, ec, cr, cc + 1, str + 'H');      // when increases the current col index -> should be moving horizontally
        print_Path(er, ec, cr + 1, cc, str + 'V');      // when increases the current row index -> should be moving vertically
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        // print_Path(last row, last column, current row index, current column index,
        // String for total Path)
        print_Path(n - 1, m - 1, 0, 0, "");
    }
}
