public class Product_Less_than_K {

    static int product_less_than_k(int[] arr, int k) {

        int start = 0;
        int end = 0;
        int ans = 0;
        int p = 1;

        while (end < arr.length) {
            p *= arr[end];

            while (p >= k) {
                p /= arr[start];
                start++;
            }

            ans += end - start + 1;
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 5, 2, 6 };
        int k = 100;

        System.out.println(product_less_than_k(arr, k));
    }
}
