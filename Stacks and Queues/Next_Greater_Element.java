import java.util.*;

public class Next_Greater_Element {

    static void next_greater_element(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {        // since we are storing the index of the array -> { arr } in the stack
                int index = stack.pop();
                nge[index] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            nge[index] = -1;
        }

        display(nge);
    }

    static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 11, 3, 23, 9, 15 };
        next_greater_element(arr);
    }
}
