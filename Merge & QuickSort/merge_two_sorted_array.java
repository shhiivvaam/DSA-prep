public class merge_two_sorted_array {
    static int[] merge(int[] one, int[] two) {

        int ans[] = new int[one.length + two.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < one.length && j < two.length) {
            if (one[i] <= two[j]) {
                ans[k] = one[i++];
            } else {
                ans[k] = two[j++];
            }
            k++;
        }
        while (i < one.length) {
            ans[k++] = one[i++];
        }
        while (j < two.length) {
            ans[k++] = two[j++];
        }

        return ans;

        // int[] result = new int[one.length + two.length];
        // int i = 0, j = 0, k = 0;
        // while (i < one.length && j < two.length) {
        // if (one[i] <= two[j]) {
        // result[k++] = one[i++];
        // } else {
        // result[k++] = two[j++];
        // }
        // }
        // while (i < one.length) {
        // result[k++] = one[i++];
        // }
        // while (j < two.length) {
        // result[k++] = two[j++];
        // }
        // return result;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        int arr2[] = { 6, 7, 8, 9, 10, 11, 12 };

        int ans[] = merge(arr1, arr2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
