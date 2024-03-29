import java.util.*;
import java.util.PriorityQueue;

public class kth_Maximum {
    public static void main(String[] args) {

        int k = 4;
        int arr[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // // max Heap

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        System.out.println(pq.peek());

    }
}
