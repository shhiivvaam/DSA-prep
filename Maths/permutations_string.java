package Maths;
// public class permutations_string {

//     public static void print_permuations(String str, String newString) {
//         if(str.length() == 0) {
//             System.out.println(newString);
//             return;
//         }

//         for(int i = 0;i<str.length();i++) {
//             String permutation = str.substring(0,i) + str.substring(i+1);

//             print_permuations(permutation, newString+permutation);
//         }
//     }
//     public static void main(String[] args) {
//         String str = "ABC";

//         print_permuations(str, "");
//     }
// }

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}