public class Maximum_Sum {

    static int maximum_Sum(int[] arr, int k) {
        int sum = 0;
        for(int i = 0;i<k;i++) {
            sum += arr[i];
        }

        int max = sum;
        for(int i = max;i<arr.length;i++) {
            sum += arr[i] - arr[i-k];
            max = Math.max(max, sum);
        }
        return max;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        System.out.println(maximum_Sum(arr, k));
    }
}
