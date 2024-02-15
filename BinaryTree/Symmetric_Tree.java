public class Symmetric_Tree {
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

    public boolean isSymmetric(TreeNode root) {
        return mirror(root.left, root.right);
    }

    public boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        boolean left_tree = mirror(left.left, right.right);
        boolean right_tree = mirror(left.right, right.left);
        return left_tree && right_tree;
    }

    // public boolean checkSymmetric(TreeNode one, TreeNode two) {
    //     if (one == null || two == null)
    //         return one == two;

    //     return one.val == two.val && checkSymmetric(one.left, two.right) && checkSymmetric(one.right, two.left);
    // }

    // public boolean isSymmetric(TreeNode root) {
    //     return checkSymmetric(root.left, root.right);
    // }

    public static void main(String[] args) {

    }
}
