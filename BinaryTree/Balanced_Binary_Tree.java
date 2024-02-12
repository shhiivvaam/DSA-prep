public class Balanced_Binary_Tree {

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

    public class Balanced_Pair {
        boolean isbal = true;
        int ht = -1;
    }

    public Balanced_Pair isBalanced(TreeNode root) {
        if (root == null)
            return new Balanced_Pair();

        Balanced_Pair left = isBalanced(root.left);
        Balanced_Pair right = isBalanced(root.right);

        Balanced_Pair self = new Balanced_Pair();
        self.ht = Math.max(left.ht, right.ht) + 1;
        int balanced = Math.abs(left.ht - right.ht);

        self.isbal = balanced <= 1 && left.isbal && right.isbal;
        return self;
    }

    public static void main(String[] args) {
        // root = [1,2,2,3,3,null,null,4,4]; // true // false
        // return isBalanced(root).isbal;
    }
}
