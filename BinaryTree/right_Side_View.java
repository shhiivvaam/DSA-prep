import java.util.*;

public class right_Side_View {

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

    public static void main(String[] args) {

    }

    class Solution {
        static int depth;

        public List<Integer> rightSideView(TreeNode root) {
            // approach:
            // > perform level order traveral using queue
            // > in each traversal store the last node val in the List
            // > return list -> since the list contains all the last elements form the
            // traversal -> means the right element

            // List<Integer> list = new ArrayList<>();
            // if(root == null) return list;

            // Queue<TreeNode> q = new LinkedList<>();
            // q.add(root);

            // while(!q.isEmpty()) {
            // int len = q.size();
            // List<Integer> arr = new ArrayList<>();

            // for(int i = 0;i<len;i++) {
            // TreeNode now = q.poll();
            // arr.add(now.val);

            // if(now.left != null) q.add(now.left);
            // if(now.right != null) q.add(now.right);
            // }
            // list.add(arr.get(arr.size()-1));
            // }
            // return list;

            // approach: 2

            depth = -1;
            List<Integer> list = new ArrayList<>();
            helper(root, list, 0);
            return list;
        }

        public void helper(TreeNode root, List<Integer> list, int curr_depth) {
            if (root == null) {
                return;
            }

            if (curr_depth > depth) {
                list.add(root.val);
                depth = curr_depth;
            }

            // we have to start with the right side first
            helper(root.right, list, curr_depth + 1);
            helper(root.left, list, curr_depth + 1);
        }
    }
}
