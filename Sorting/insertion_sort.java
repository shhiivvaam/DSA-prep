package Sorting;
public class insertion_sort {
    public static void main(String[] args) {
        int arr[] = {1,4,6,3,2,5,6,9,1,5,8,3,579,34,2,6,2};

        // insertion sort code?

        int i = 0;
        while(i < arr.length) {
            int temp = arr[i];

            int j = i-1;

            while(j>=0 && arr[j] > temp) {
                    arr[j+1] = arr[j];
                    j--;
            }
            arr[j+1] = temp;
        }

        for(int k = 0;k<arr.length;k++) {
            System.out.print(arr[k]);
        }

    }
}