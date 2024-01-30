public class Split_equal_sum_Array {

    static int count = 0;

    static void subset_partition_equal_sum(int[] arr, int index, String one, int sum1, String two, int sum2) {
        if (index == arr.length) {
            if (sum1 == sum2) {
                System.err.println(one + "and " + two);
                count++;
            }
            return;
        }

        subset_partition_equal_sum(arr, index + 1, one + arr[index] + " ", sum1 + arr[index], two, sum2);
        subset_partition_equal_sum(arr, index + 1, one, sum1, two + arr[index] + " ", sum2 + arr[index]);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 4, 5 };

        subset_partition_equal_sum(arr, 0, "", 0, "", 0);
        System.out.println(count);
    }

}
