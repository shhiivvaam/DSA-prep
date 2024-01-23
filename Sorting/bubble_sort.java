package Sorting;
public class bubble_sort {
    public static void main(String[] args) {
        int arr[] = {3,5,4,5,1,4,5,2,5,1,4,5,1,5};

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length-2;j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
