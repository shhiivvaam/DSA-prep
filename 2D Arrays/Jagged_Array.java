import java.util.*;

public class Jagged_Array {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int n = ask.nextInt();

        int[][] arr = new int[n][];

        for (int i = 0; i < arr.length; i++) {
            int col = ask.nextInt();
            arr[i] = new int[col];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ask.nextInt();
            }
        }

        // printing 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        ask.close();
    }
}