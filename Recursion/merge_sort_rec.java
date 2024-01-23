public class merge_sort_rec {
    public static void merge(int arr[], int i, int j) {

        int mid = i + (j - i) / 2;

        int len1 = mid - i + 1;
        int len2 = j - mid;

        int first[] = new int[len1];
        int second[] = new int[len2];

        // copying the values
        int k = i;
        for (int start = 0; start < len1; start++) {
            first[start] = arr[k++];
        }

        k = mid + 1;
        for (int start = 0; start < len2; start++) {
            second[start] = arr[k++];
        }

        // merge funtion

        int index1 = 0;
        int index2 = 0;

        k = i;
        while (index1 < len1 && index2 < len2) {
            if (first[index1] < second[index2]) {
                arr[k++] = first[index1++];
            } else {
                arr[k++] = second[index2++];
            }
        }
        while (index1 < len1) {
            arr[k++] = first[index1++];
        }
        while (index2 < len2) {
            arr[k++] = second[index2++];
        }

    }

    public static void mergeSort(int arr[], int i, int j) {
        if (i >= j) {
            return;
        }

        int mid = i + (j - i) / 2;

        // left part sorting
        mergeSort(arr, i, mid);

        // right part sortiung
        mergeSort(arr, mid + 1, j);

        merge(arr, i, j);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 3, 5, 6, 8, 6, 4, 3 };

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}