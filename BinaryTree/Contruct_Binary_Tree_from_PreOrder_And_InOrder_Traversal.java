public class Contruct_Binary_Tree_from_PreOrder_And_InOrder_Traversal {
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

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return Create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode Create(int[] preorder, int plo, int phi, int[] inorder, int ilo, int ihi) {
            // plo -> preorder low phi => preorder high
            // ilo -> inorder low ihi -> inirder high

            if (ilo > ihi || plo > phi) {
                return null;
            }

            TreeNode node = new TreeNode(preorder[plo]);

            int index = Search(inorder, ilo, ihi, preorder[plo]);
            // int index = Search(inorder, ilo, ihi, node.val);
            int netElement = index - ilo;

            node.left = Create(preorder, plo + 1, plo + netElement, inorder, ilo, index - 1);
            node.right = Create(preorder, plo + netElement + 1, phi, inorder, index + 1, ihi);

            return node;
        }

        private int Search(int[] inorder, int ilo, int ihi, int item) {
            for (int i = ilo; i <= ihi; i++) {
                if (inorder[i] == item) {
                    return i;
                }
            }
            return -1;
        }
    }
}
