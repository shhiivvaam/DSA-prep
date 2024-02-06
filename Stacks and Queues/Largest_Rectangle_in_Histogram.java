import java.util.*;

public class Largest_Rectangle_in_Histogram {

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for(int i = 0;i<arr.length;i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int r = i;
                int h = arr[stack.pop()];

                if(stack.isEmpty()) {
                    ans = Math.max(ans, h*r);
                } else {
                    int l = stack.peek();
                    ans = Math.max(ans, h* (r-l-1));
                }
            }
            stack.push(i);
        }

        int r = arr.length;
        while(!stack.isEmpty()) {
            int h = arr[stack.pop()];

            if(stack.isEmpty()) {
                ans = Math.max(ans, h*r);
            } else  {
                int l = stack.peek();
                ans = Math.max(ans, h* (r-l-1));
            }
        }
        return ans;
    }
}