import java.util.*;

public class BinaryTree {

    Scanner ask = new Scanner(System.in);

    private Node root;

    public class Node {
        int data;
        Node left;
        Node right;
    }

    public BinaryTree(){
        this.root = createTree();
    }

    private Node createTree() {
        int item = ask.nextInt();

        Node node = new Node();
        node.data = item;

        boolean hlc = ask.nextBoolean();
        if (hlc == true) {
            node.left = createTree(); // left Subtree
        }

        boolean hlr = ask.nextBoolean();
        if (hlr == true) {
            node.right = createTree(); // right Subtree
        }
    }

    public void Display() {
        Display(this.root);
    }

    private void Display(Node node) {
        if (node == null)
            return;

        String str = "";
        str = str + node.data;
        str = "<---" + str + "--->";
        if (node.left != null) {
            str = node.left.data + str;
        } else {
            str = "." + str;
        }

        if (node.right != null) {
            str = str + node.right.data;
        } else {
            str = str + '.';
        }

        System.out.println(str);
        Display(node.left); // left subtree visit
        Display(node.right); // right subtree visit
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int lmax = max(node.left);
        int rmax = max(node.right);

        return Math.max(lmax, Math.max(rmax, node.data));
    }

    public boolean find(int item) {
        return find(this.root, item);
    }

    private boolean find(Node node, int item) {
        if (node == null)
            return false;
        if (node.data == item)
            return true;
        return find(node.left, item) || find(node.right, item);
    }

    public int ht() {
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;
        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(lh, rh) + 1;
    }
}
