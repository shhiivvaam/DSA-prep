public class flip_Equivalent_Binary_Tree {
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

    public boolean flipEquiv(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        boolean flip = flipEquiv(left.left, right.right) && flipEquiv(left.right, right.left);

        // There might be possibility that we need not to flip the tree
        boolean noflip = flipEquiv(left.left, right.left) && flipEquiv(left.right, right.right);
        return flip || noflip; // we can be satisfied with any of the operations, where we get the answer with
                               // flipping or without flipping
    }

    public static void main(String[] args) {

    }
}
