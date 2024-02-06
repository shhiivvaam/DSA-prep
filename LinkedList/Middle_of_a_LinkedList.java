public class Middle_of_a_LinkedList {
    public class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) { // ! fast.next.next != null } this is the case to handle for even
                                                    // length of Node
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        Node one = headA;
        Node two = headB;

        while(one != two) {
            if(one == null) {
                one = headB;
            } else {
                one = one.next;
            }

            if(two == null) {
                two = headA;
            } else {
                two = two.next;
            }
        }
        return one;
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        Node node = new Node();
        Node temp = node;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }

        if(list1 == null) {
            temp.next = list2;
        }
        if(list2 == null) {
            temp.next = list1;
        }

        return node.next;
    }

    public static void main(String[] args) {

    }
}
