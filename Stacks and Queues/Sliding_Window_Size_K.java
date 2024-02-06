import java.util.*;

public class Sliding_Window_Size_K {

    public static int[] maxWindow(int[] arr, int k) {
        int n = arr.length;
        int[] max = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.add(i); // last mai add krega
        }
        max[0] = arr[dq.getFirst()]; // 1st windowka maximum
        int j = 1;

        for (int i = k; i < n; i++) {
            // window i-k tak remove
            while (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.remove(); // remove first KRega
            }

            while (!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.add(i);

            max[j++] = arr[dq.getFirst()];
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(Arrays.toString(maxWindow(arr, 3)));
    }
}
