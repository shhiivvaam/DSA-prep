public class Sum_root_to_Leaf_Number {
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

    public int sum_root_to_leaf_number(TreeNode root, int sum) {

        if(root == null) return 0;

        if(root.left == null && root.right == null) {
            return sum*10 + root.val;
        }

        int left = sum_root_to_leaf_number(root.left, sum*10 + root.val);
        int right = sum_root_to_leaf_number(root.right, sum*10 + root.val);

        return left+right;
    }

    public static void main(String[] args) {
        // root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        // return sum_root_to_leaf_number(root, 0);
    }
}
