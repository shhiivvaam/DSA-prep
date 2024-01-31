public class Merge_Sort {

    static int[] merge_Two_Sorted_Array(int[] one, int[] two) {

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

    }

    static int[] merge_sort(int[] arr, int low, int high) {

        if (low == high) { // it means only one element is left
            int temp[] = new int[1];
            temp[0] = arr[low];
            return temp;
        }

        int mid = (low + high) / 2;

        int[] one = merge_sort(arr, low, mid);
        int[] two = merge_sort(arr, mid + 1, high);
        return merge_Two_Sorted_Array(one, two);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 6, 7, 4, 5, 7, 7, 5, 34, 547, 7 };
        int ans[] = merge_sort(arr, 0, arr.length - 1);

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
