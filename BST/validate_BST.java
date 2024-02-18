public class validate_BST {
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

    public class BST_Pair {
        boolean isbst = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return validBST(root).isbst;
        }

        public BST_Pair validBST(TreeNode root) {

            if(root == null){
                return new BST_Pair();
            }

            BST_Pair lbst = validBST(root.left);
            BST_Pair rbst = validBST(root.right);

            BST_Pair sbst = new BST_Pair();
            if (lbst.isbst == true && rbst.isbst == true && lbst.max < root.val && rbst.min > root.val) {
                sbst.isbst = true;
                sbst.max = Math.max(rbst.max, root.val);
                sbst.min = Math.min(lbst.min, root.val);

                return sbst;
            }

            sbst.isbst = false;
            sbst.max = Math.max(rbst.max, Math.max(lbst.max, root.val));
            sbst.min = Math.min(rbst.min, Math.min(lbst.min, root.val));

            return sbst;
        }
    }
}
