import java.util.Arrays;

public class Rotate_Array {
    static void Rotate_Array1(int[] arr, int k) {
        k = k % arr.length;
        for (int j = 0; j < k; j++) {
            int temp = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
        }
    }

    static void Rotate_Array2(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        // Rotate_Array1(arr, k);
        // System.out.println(Arrays.toString(arr));

        // ! using the Reversal Algorithm
        Rotate_Array2(arr, 0, arr.length - k - 1);
        Rotate_Array2(arr, arr.length - k, arr.length - 1);
        Rotate_Array2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
