public class BinarySearchTree {
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

    private TreeNode root;

    public BinarySearchTree(int[] tree) {
        this.root = CreateTree(tree, 0, tree.length - 1);
    }

    private TreeNode CreateTree(int[] tree, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode();
        node.val = tree[mid];

        node.left = CreateTree(tree, start, mid - 1);
        node.right = CreateTree(tree, mid + 1, end);

        return node;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        if (val > root.val)
            root.right = insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // consider the casse when the root has 0(leaf node), 1 and 2 childs
        if (root.val == key) {
            // Case for handling 0 || 1 child nodes
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            // Case for handling 2 child nodes
            else {
                // here we have choices
                // 1. take the max of the leftSubtree of the root
                // 2. take the min of the rightSubtree of the root

                // going with choice 1
                int leftMax = max(root.left);
                // now we can go with two cases:
                // 1. find the maximum of the left Subtree
                // 2. find the minimum of the right Subtree

                // then replace it with the root val and delete the finded node from the
                // respective left/right Subtree
                root.left = deleteNode(root.left, leftMax);
                root.val = leftMax;
            }
        }

        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else
            root.left = deleteNode(root.left, key);

        return root;
    }

    public int max(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int max = max(root.right);
        return Math.max(max, root.val);
    }

    public int min(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int min = min(root.left);
        return Math.min(min, root.val);
    }

}
