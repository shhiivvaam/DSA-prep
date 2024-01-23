import java.util.Scanner;

public class wave_print {
    static void wave_print1(int[][] arr) {
        
        System.out.println("wave print : ");

        for(int col = 0;col<arr[0].length;col++) {
            if(col%2 == 0){
                for(int row = 0;row<arr.length;row++) {
                    System.out.print(arr[row][col] + " ");
                }
                System.out.println();
            } else {
                for(int row = arr.length-1;row>=0;row--) {
                    System.out.print(arr[row][col] + " ");
                }
                System.out.println();
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

        print(arr);
        System.out.println("----------------------------------------------------");
        
        // function to print the wave array
        wave_print1(arr);
        System.out.println("----------------------------------------------------");

        ask.close();
    }
}
