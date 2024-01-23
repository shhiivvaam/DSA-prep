public class circular_max_Subarray {
    // static int max_Circular_Subarray_Sum(int[] arr) {
    // //? steps :
    // // * first invert every no ( multiply by -1) -.> for handling cases in which
    // all the elements are negative
    // // * then find the subarray max and the whole array sum
    // // * then take the difference of the array sum and the subarray max sum
    // // * since at the start we have inverted the values, so invert the differnece
    // and return

    // for(int i =0;i<arr.length;i++) {
    // arr[i] = -arr[i];
    // }

    // int max_sub_sum = kadanes(arr);
    // int sum = 0;

    // for(int i = 0;i<arr.length;i++) {
    // sum += arr[i];
    // }
    // int diff = sum - max_sub_sum;
    // return -diff;
    // }

    static int circular_max_Subarray1(int[] arr) {

        int kadane = kadanes(arr);
        // System.out.println(kadane);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // System.out.println(sum);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -arr[i];
        }
        int max_sub_sum = kadanes(arr);
        // System.out.println(max_sub_sum);

        int ans = sum + max_sub_sum;
        // System.out.println(ans);
        return Math.max(kadane, ans);

    }

    static int kadanes(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(sum, max);

            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 23, 45, -78, -89, 100 };
        // int arr[] = { -18 };

        // function to find the max Circular Subarray Sum
        System.out.println(circular_max_Subarray1(arr));
    }
}
