import java.util.Arrays;

public class product_except_self {
    static void product_except_self1(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = 1;
        for(int i = 1;i<arr.length;i++) {
            left[i] = left[i-1] * arr[i-1];
        }

        right[arr.length-1] = 1;
        for(int i = arr.length-2;i>=0;i--) {
            right[i] = right[i+1] * arr[i+1];
        }

        for(int i = 0;i<arr.length;i++) {
            arr[i] = left[i] * right[i];
        }
    }

    static void product_except_self2(int[] arr) {
        
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,4};
        // product_except_self1(arr);
        // System.out.println(Arrays.toString(arr));

        product_except_self2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
