import java.util.*;

public class Counting_Sort {

    // ? Except this sorting algorithm all other sorting algorithms are comparison
    // based sorting techniques
    public static void main(String[] args) {
        int arr[] = { 2, 1, 1, 0, 1, 2, 5, 4, 0, 2, 8, 7, 9, 2, 6, 1, 9 };
        System.out.println(Arrays.toString(Sort(arr)));
    }

    static int[] Sort(int[] arr) {

        // finding the maximum element from the array
        int max = Arrays.stream(arr).max().getAsInt();

        // creating a frequency array for the elements of the given array
        int[] frq = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            frq[arr[i]]++;
        }

        // adding the count of the frequecny array to know the range of the numbers each
        // elements need to be filled
        for (int i = 1; i < frq.length; i++) {
            frq[i] = frq[i - 1] + frq[i]; // curr_elem = prev_elem + curr_elem
        }

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = frq[arr[i]];
            ans[pos - 1] = arr[i];
            frq[arr[i]]--;
        }

        return ans;
    }
}
