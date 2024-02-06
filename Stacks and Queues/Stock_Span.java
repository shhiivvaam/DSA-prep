import java.util.*;

public class Stock_Span {

    static void stock_span(int[] arr) {
        int[] span = new int[arr.length];
        Arrays.fill(span, 1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) { // since we are storing the index of the array -> {
                                                                     // arr } in the stack
                stack.pop();
            }

            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }

        display(span);
    }

    static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 91, 11, 13, 15, 38, 42, 37 };
        stock_span(arr);
    }
}
