import java.util.*;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] arr = {2,4,5,7,8,1,3,9,11,10,16,15,1};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - 1))
                map.put(nums[i], false);
            else
                map.put(nums[i], true);

            if (map.containsKey(nums[i] + 1))
                map.put(nums[i] + 1, false);
        }

        int ans = 0;
        for (int val : map.keySet()) {
            if (map.get(val) == true) {
                int count = 0;
                while (map.containsKey(val)) {
                    count++;
                    val++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}