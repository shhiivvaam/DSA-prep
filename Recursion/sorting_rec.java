public class sorting_rec {
    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void sort(int arr[], int n) {
        if(n == 0 || n == 1) return;

        for(int i = 0;i<n-1;i++) {
            if(arr[i] > arr[i+1]) swap(arr, i, i+1);

        }

        sort(arr, n-1);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 8, 4, 3, 1};
        sort(arr, arr.length);
        for(int i : arr) {
            System.err.print(i + " ");
        }
    }
}