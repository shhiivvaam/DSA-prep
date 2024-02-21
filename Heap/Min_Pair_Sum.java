import java.util.*;

public class Min_Pair_Sum {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 6, 7, 82, 3, 5, 6, 1, 3 };
        System.out.println(minPairSum(arr));
    }

    public static int minPairSum(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += a + b;
            pq.add(a + b);
        }

        return sum;
    }
}
