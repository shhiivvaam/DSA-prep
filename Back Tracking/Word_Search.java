public class Word_Search {

    static boolean word_search(char[][] maze, int cr, int cc, String word, int index) {

        if(index == word.length()) {        // main base case
            return true;
        }

        if(cr >= maze.length || cc >= maze[0].length || cr<0 || cc <0 || maze[cr][cc] != word.charAt(index)) {                                                         //* remeber this important base case written above witht he last condition */
            return false;
        }

        int row[] = {0, -1, 0, 1};
        int col[] = {1, 0, -1, 0};

        // int row[] = {-1, 1, 0, 0};
        // int col[] = {0, 0, 1, -1};


        maze[cr][cc] = '*';       // replacing the current index of the matrix with some character that is not present in the entire matrix
                                // because here we know that if we have reached this point eans the base case must also got a hit, and so we have checked that we are on the right doirection of finding the word, since the current index of the word matches the current index of the matrix > so we are not marking this index of the maze as some new chsr that will not match with the chars present in the matric, and so the recursion will not check this index and proceed to other indexes, and so we are preventing the infnite recursion calls
        for(int i = 0;i<col.length;i++) {
            boolean ans = word_search(maze, cr + row[i], cc + col[i], word, index+1);

            if(ans == true) {
                return ans;           //* there is a difference in return true and return ans
            }
        }
        maze[cr][cc] = word.charAt(index);                // backtracking step  > make the current index of the matrix back to the previous state { that is before marking as '*' > so that we can check that index again if required}
        return false;
    }
    public static void main(String[] args) {
        char[][] maze = { {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        for(int i = 0;i<maze.length;i++) {
            for(int j = 0;j<maze[0].length;j++) {
                if(maze[i][j] == word.charAt(0)) {          // if we find an index in the maze matrix which has the first char of the word, then only their is a logic to start finding the word int the matrix
                    boolean ans = word_search(maze, i, j, word, 0);
                    if(ans == true) {
                        System.out.println(ans);
                        return;
                    }
                }
            }
        }
        System.out.println(false);
    }
}
