import java.util.*;

public class Maximal_Rectangle {
    public static int maximalRectangle(int[][] matrix) {
        int arr[][] = new int[matrix.length][matrix[0].length];
        int ans = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == arr.length - 1) {
                    arr[i][j] = matrix[i][j];
                } else {
                    arr[i][j] = matrix[i][j] == 1 ? arr[i + 1][j] + 1 : 0;
                }
            }
            ans = Math.max(ans, Area(arr[i]));
        }
        return ans;
    }

    public static int Area(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int r = i;
                int h = arr[stack.pop()];

                if (stack.isEmpty()) {
                    ans = Math.max(ans, h * r);
                } else {
                    int l = stack.peek();
                    ans = Math.max(ans, h * (r - l - 1));
                }
            }
            stack.push(i);
        }

        int r = arr.length;
        while (!stack.isEmpty()) {
            int h = arr[stack.pop()];

            if (stack.isEmpty()) {
                ans = Math.max(ans, h * r);
            } else {
                int l = stack.peek();
                ans = Math.max(ans, h * (r - l - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1, 0, 0 },
                { 1, 0, 1, 1, 1 } };
        System.out.println("Maximal Rectangle is " + maximalRectangle(matrix));
    }

}
