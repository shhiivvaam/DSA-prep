public class Lowest_Common_Ancestor2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(find(root, p) == false || find(root, q) == false) {
            return null;
        }

        return LCA(root, p, q);
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null)
            return right;
        else
            return left;
    }

    public boolean find(TreeNode root, TreeNode f) {
        if (root == null)
            return false;

        if (root == f)
            return true;

        return find(root.left, f) || find(root.right, f);
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
