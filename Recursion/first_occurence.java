public class first_occurence {

    static int first_occurence1(int[] arr, int index, int element) {
        if(index == arr.length) return -1;
        if(arr[index] == element) return index;

        return first_occurence1(arr, index + 1, element);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,7,8,8,9};
        System.out.println(first_occurence1(arr, 0, 7));
    }
}
