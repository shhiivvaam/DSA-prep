import java.util.*;

public class Rat_In_A_Maze {

    static boolean flag = false;

    static void rat_in_a_maze1(char[][] maze, int cr, int cc, int[][] ans) {

        if (cc == maze[0].length - 1 && cr == maze.length - 1) {      // base case
            if(maze[cr][cc] == 'O') {            // last condition when, we have reached the end of the maze, i.e, the last row&&col index > then make the ans {row&&col} index 1
                flag = true;                     // for confirming that some path exist
                ans[cr][cc] = 1;                 // last step when we have reached the last col&&row index > mark the ans matrix as 1, since there we find the { cheese }
                display(ans);
                ans[cr][cc] = 0;                 // backtracking step
            }
            return;
        }

        if (cr >= maze.length || cc >= maze[0].length || cc < 0 || cr < 0 || maze[cr][cc] == 'X') {
            return;         // base case
        }

        int row[] = { 0, -1, 0, 1 };
        int col[] = { 1, 0, -1, 0 };

        // rat_in_a_maze1(maze, cr, cc+1, ans); // right
        // rat_in_a_maze1(maze, cr-1, cc, ans); // up
        // rat_in_a_maze1(maze, cr, cc-1, ans); // left
        // rat_in_a_maze1(maze, cr+1, cc, ans); // down

        maze[cr][cc] = 'X';
        ans[cr][cc] = 1;
        for (int i = 0; i < col.length; i++) {
            rat_in_a_maze1(maze, cr + row[i], cc + col[i], ans);
        }
        maze[cr][cc] = 'O';
        ans[cr][cc] = 0;
    }

    static void display(int[][] ans) {

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner ask = new Scanner(System.in);
        int n = ask.nextInt();
        int m = ask.nextInt();
        char maze[][] = new char[n][m];

        // Maze Input
        for (int i = 0; i < maze.length; i++) {
            String s = ask.next();
            for (int j = 0; j < s.length(); j++) {
                maze[i][j] = s.charAt(j);
            }
        }

        int[][] ans = new int[n][m]; // answer array
        rat_in_a_maze1(maze, 0, 0, ans);

        if(flag == false) {
            System.out.println("Path Not Found");
        }

        ask.close();
    }
}
