import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
}

public class BinaryTree {

    Scanner ask = new Scanner(System.in);

    class Node {
        int data;
        Node left;
        Node right;
    }

    private Node root;

    public BinaryTree() {
        this.root = createTree();
    }

    private Node createTree() {
        int item = ask.nextInt();
        Node node = new Node();
        node.data = item;

        boolean hasLeft = ask.nextBoolean();
        if (hasLeft == true) {
            node.left = createTree();
        }
        boolean hasRight = ask.nextBoolean();
        if (hasRight == true) {
            node.right = createTree();
        }

        return node;
    }

    public int max() {
        return max(this.root);
    }

    public int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int Lmax = max(node.left);
        int Rmax = max(node.right);

        return Math.max(Lmax, Math.max(Rmax, node.data));
    }

    public boolean find(int item) {
        return find(this.root, item);
    }

    private boolean find(Node node, int item) {
        if (node == null)
            return false;

        if (node.data == item) {
            return true;
        }
        return find(node.left, item) || find(node.right, item);
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        // return 1 + Math.max(height(node.left), height(node.right));

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(Node root) {
        if(root == null) return 0;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        int self = height(root.left) + height(root.right) +2;

        return Math.max(left, Math.max(right, self));
    }

    // public void LevelOrder() {
    // LinkedList<Node> queue = new LinkedList<>();
    // // Queue<Node> queue = new LinkedList<>()

    // queue.add(this.root); // add last
    // while (!queue.isEmpty()) {
    // Node remove = queue.remove(); // remove first
    // System.out.println(remove.data + " ");

    // if (remove.left != null) {
    // queue.add(remove.left);
    // }
    // if (remove.right != null) {
    // queue.add(remove.right);
    // }
    // }
    // System.out.println();
    // }

    public void Display(Node node) {
        String str = "";
        str += node.data;

        // making the initial node answer String
        str = "<---" + str + "--->";

        // checking for left
        if (node.left != null) {
            str = node.left.data + str;
        } else {
            str = "." + str;
        }

        // checking for right
        if (node.right != null) {
            str = str + node.right.data;
        } else {
            str = str + ".";
        }

        System.out.println(str);
        Display(node.left);
        Display(node.right);
    }
}