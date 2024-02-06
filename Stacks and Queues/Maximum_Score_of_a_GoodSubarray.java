import java.util.*;

public class Maximum_Score_of_a_GoodSubarray {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 3, 7, 4, 5 };
        int k = 3;
        System.out.println(Area(arr, k));
    }

    public static int Area(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int r = i; // r is not the part of an intervl , since the interval if upto { r-1 }
                int h = arr[stack.pop()];

                if (r - 1 >= k) {
                    if (stack.isEmpty()) {
                        ans = Math.max(ans, h * r);
                    } else {
                        int l = stack.peek(); // since l is not a part of the interval, but { l+1 } is

                        if (l + 1 <= k)
                            ans = Math.max(ans, h * (r - l - 1));
                    }
                }
            }
            stack.push(i);
        }

        int r = arr.length;
        while (!stack.isEmpty() && r - 1 >= k) {
            int h = arr[stack.pop()];

            if (stack.isEmpty()) {
                ans = Math.max(ans, h * r);
            } else {
                int l = stack.peek(); // since l is not a part of the interval, but { l+1 } is

                if (l + 1 <= k)
                    ans = Math.max(ans, h * (r - l - 1));
            }
        }
        return ans;
    }

}
