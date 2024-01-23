import java.util.*;

public class transpose_matrix {

    static void transpose(int[][] arr){
        for(int i =0;i<arr.length;i++) {
            for(int j = i+1;j<arr.length;j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
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

        // function to transpose the matrix
        transpose(arr);


        print(arr);
        System.out.println("----------------------------------------------------");


        ask.close();
    }
}
