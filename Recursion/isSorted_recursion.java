public class isSorted_recursion {
    public static boolean sorted(int arr[], int size) {
        // bsse case
        if(size == 0 || size == 1) return true;

        // if(arr[0] > arr[1]) return false;                                // for c++  (write this and delete the just below attached(commented) code
        if(arr[size - 2] > arr[size - 1]) return false;
        else {
            boolean remainingPart = sorted(arr, size-1);                     // for c++    -> arr+1
            return remainingPart;

            //! OR can be returned by :
                                // return sorted(arr, size-1);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,3,525};
        int size = 6;

        boolean ans = sorted(arr, size);

        if(ans) System.out.println("Sorted");
        else System.out.println("Not Sorted");
    }
}