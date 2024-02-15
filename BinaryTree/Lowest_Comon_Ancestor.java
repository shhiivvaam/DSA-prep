public class Lowest_Comon_Ancestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null)
            return right;
        else
            return left;
    }

    public static void main(String[] args) {
        // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        // TreeNode root = new TreeNode(1);
        // TreeNode p = new TreeNode(3);
        // TreeNode q = new TreeNode(4);
        // TreeNode ans = lowestCommonAncestor(root, p, q);
        // System.out.println(ans);
    }
}
