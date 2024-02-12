import java.util.*;

public class Path_Sum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSumI(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }

        // * This way we are returning the answer by calculating both the left and right
        // tree, but if we are getting answer in some { left/ right } we can directly
        // return the answer ie.,
        // boolean left = hasPathSum(root.left, sum- root.val);
        // boolean right = hasPathSum(root.right, sum- root.val);
        // return left || right;

        return hasPathSumI(root.left, sum - root.val) || hasPathSumI(root.right, sum - root.val);
    }

    // Path sum II has a List<List<Integer>> that contains the list of all the paths
    // that summ up with the given Sum
    public void pathSumII(TreeNode root, int sum, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> list) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && sum - root.val == 0) {
            arr.add(root.val);
            list.add(new ArrayList<>(arr));
            arr.remove(arr.size() - 1);
        }

        arr.add(root.val);
        pathSumII(root.left, sum - root.val, arr, list);
        pathSumII(root.right, sum - root.val, arr, list);
        arr.remove(arr.size() - 1);
    }

    public static void main(String[] args) {
        // root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22

        // ! Path Sum I
        // hasPathSumI(TreeNode root, int sum);

        // ! Path Sum II
        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        // hasPathSumII(TreeNode root, int sum, arr, list);
    }
}