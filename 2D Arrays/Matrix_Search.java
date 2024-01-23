import java.util.*;

public class Matrix_Search {
    static int search_matrix(int[][] arr, int x) {

        int row = 0;
        int col = arr[0].length-1;

        while(row <= arr.length-1 && col >= 0) {
            if(arr[row][col] == x) return 1;
            else if(arr[row][col] < x) {
                row++;
            } else col--;
        }
        return -1;
            
        // while(row != arr.length-1 && col != 0) {
        //     if(arr[row][col] == x) {
        //         return 1;
        //     } else if(arr[row][col] > x) {
        //         col--;
        //     } else {
        //         row++;
        //     }
        // }
        // return -1;
    }
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int n = ask.nextInt();
        int m = ask.nextInt();

        int arr[][] = new int[n][m];
        for(int i = 0;i<arr.length;i++) {
            for(int j = 0;j<arr.length;j++) {
                arr[i][j] = ask.nextInt();
            }
        }

        int x = ask.nextInt();           // search element

        System.out.println(search_matrix(arr, x));

        ask.close();
    }
}
