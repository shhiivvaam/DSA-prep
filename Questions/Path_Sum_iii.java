public class Path_Sum_iii {

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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int root_sum = CountNumberOfPath(root, targetSum); /// root data included
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);

        return root_sum + left + right;
    }

    public int CountNumberOfPath(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int ans = 0;
        if ((targetSum - root.val) == 0)
            ans++;

        ans += CountNumberOfPath(root.left, targetSum - root.val);
        ans += CountNumberOfPath(root.right, targetSum - root.val);

        return ans;
    }
}