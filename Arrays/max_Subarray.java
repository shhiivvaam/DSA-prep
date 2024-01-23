public class max_Subarray {
    static int max_Subarray1(int[] arr) {

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int prev = 0;
            for (int j = i; j < arr.length; j++) {
                prev += arr[j];
                ans = Math.max(prev, ans);
            }
        }
        return ans;
    }

    static int kadanes_algorithm(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // System.out.println(max_Subarray1(arr));
        System.out.println(kadanes_algorithm(arr));
    }
}
