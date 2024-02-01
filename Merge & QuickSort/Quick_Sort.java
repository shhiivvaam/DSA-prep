public class Quick_Sort {

    static void quick_sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int index = Partition(arr, low, high);
        quick_sort(arr, low, index - 1);
        quick_sort(arr, index + 1, high);
    }

    static int Partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int index = low;

        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                // swap i and index
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;

                index++;
            }
        }

        // swap index high
        int temp = arr[index];
        arr[index] = arr[high];
        arr[high] = temp;

        return pivot;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 54, 3, 4, 3, 5, -56, 1, -9, -6, 1, 6, 1, 4, 5 };
        // int index = Partition(arr, 0, arr.length - 1);
        // System.out.println(index);
        quick_sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
