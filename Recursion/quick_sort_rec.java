public class quick_sort_rec {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int arr[], int i, int j) {

        int pivot = arr[i];

        int count = 0;
        for (int start = i + 1; start <= j; start++) {
            if (arr[start] <= pivot)
                count++;
        }

        // place pivot at the right position
        int pivotIndex = i + count;
        swap(arr, pivotIndex, i);

        // left and right wala part sambhalo
        int start = i, end = j;

        while (start < pivotIndex && end > pivotIndex) {
            while (arr[start] <= pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }

            if (start < pivotIndex && end > pivotIndex) {
                swap(arr, start++, end--);
            }
        }
        return pivotIndex;
    }

    public static void quickSort(int arr[], int i, int j) {
        if (i >= j) {
            return;
        }

        int p = partition(arr, i, j);

        // left part sorting
        quickSort(arr, i, p - 1);

        // right part sortiung
        quickSort(arr, p + 1, j);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 3, 5, 6, 8, 6, 4, 3 };

        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}