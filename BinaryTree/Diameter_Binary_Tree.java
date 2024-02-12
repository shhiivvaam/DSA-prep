public class Diameter_Binary_Tree {
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

    // * This way we can find both the height and the diameter of the given Binary Tree
    public class DiaPair {
        int d = 0;
        int ht = -1;
    }

    class Solution {
        public int diameter_binary_tree(TreeNode root) {
            return diameter(root).d; // returning the return type { DiaPair } d value;
            // return diameter(root).ht; // returning the return type { DiaPair } d value;
        }

        public DiaPair diameter(TreeNode root) {
            if (root == null) {
                return new DiaPair();
            }

            DiaPair ldp = diameter(root.left);
            DiaPair rdp = diameter(root.right);
            DiaPair sdp = new DiaPair();

            sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;               // this finds the height { ht } of the given Binary Tree
            int dia = ldp.ht + rdp.ht + 2;
            sdp.d = Math.max(dia, Math.max(ldp.d, rdp.d));       // this finds the diameter { d } of the given Binary Tree 

            return sdp;
        }
    }
}
