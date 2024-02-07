public class LinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;
    private Node tail;

    public void addFirst(int item) {
        Node node = new Node(item);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
            this.size += 1;
        } else {
            node.next = head;
            this.head = node;
            this.size += 1;
        }
    }

    public void addLast(int item) {

        if (this.size == 0) {
            addFirst(item);
        } else {
            Node node = new Node(item);
            this.tail.next = node;
            this.tail = node;
            this.size += 1;
        }
    }

    public void addAtIndex(int index, int item) throws Exception { // index taken as starting from 0
        if (index < 0 || index > this.size) {
            throw new Exception("Index Out of Bound...!!");
        } else if (index == 0) {
            addFirst(item);
        } else if (index == this.size) {
            addLast(item);
        } else {
            Node temp1 = new Node(item);
            Node temp2 = getNodeAtIndex(index - 1);
            temp1.next = temp2.next;
            temp2.next = temp1;
            this.size += 1;
        }

        // Node temp = this.head;
        // int count = 0;
        // while (temp != null && count++ != index - 1) {
        // temp = temp.next;
        // count++;
        // }

        // Node indexNode = new Node(item);
        // indexNode.next = temp.next;
        // temp.next = indexNode;
        // this.size += 1;
    }

    public int getFirst() throws Exception {
        if (this.head == null) {
            throw new Exception("Linked List is Empty!!");
        }
        return this.head.data;
    }

    public int getLast() throws Exception {
        if (this.head == null) {
            throw new Exception("Linked List is Empty!!");
        }
        return this.tail.data;
    }

    public int removeFirst() throws Exception {

        // Node temp = this.head;
        // this.head = this.head.next;
        // temp.next = null;
        // size -= 1;

        // return temp.data;

        int data = getFirst();
        head = head.next;
        this.size -= 1;
        return data;
    }

    public int removeLast() throws Exception {
        if (this.head == null) {
            throw new Exception("Linked List is Empty...!!");
        }
        if (this.size == 1) {
            return removeFirst();
        }

        Node temp = getNodeAtIndex(this.size - 2);
        int data = this.tail.data;
        this.tail = temp;
        this.tail.next = null;
        this.size -= 1;

        return data;
    }

    public int removeAtIndex(int index) throws Exception {
        if (index < 0 || index >= this.size) {
            throw new Exception("Linked List is Empty..!!");
        } else if (index == 0) {
            return removeFirst();
        } else if (index == this.size - 1) {
            return removeLast();
        } else {
            Node temp1 = getNodeAtIndex(index);
            Node temp2 = getNodeAtIndex(index - 1);

            temp2.next = temp1.next;
            temp1.next = null;
            this.size -= 1;

            return temp1.data;
        }
    }

    public int getAtIndex(int index) throws Exception {

        return getNodeAtIndex(index).data;

        // if (index == 0) {
        // getFirst();
        // } else if (index == this.size - 1) {
        // getLast();
        // } else
        // return getNodeAtIndex(index).data;
    }

    private Node getNodeAtIndex(int index) throws Exception {
        if (index < 0 || index >= this.size) {
            throw new Exception("Index Out of Bound....!!!");
        }

        Node temp = this.head;
        // for (int i = 0; i < index; i++) {
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void createCycle() {
        this.tail.next = this.head.next;
        // this.tail.next = this.head.next.next;
        // this.tail.next = this.head;
    }

    public boolean hasCycle() {
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    public Node cycleNode() {
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return slow;
        }
        return null;
    }

    // Below Function Complexity -> O(n2)
    public void removeCycle1() {
        Node cycle = cycleNode();
        if (cycle == null)
            return; // calling the cycleNode to return the { node } where cycle is detected, if not
                    // -> it will return null

        Node start = this.head;
        while (start != null) {

            Node temp = cycle;
            while (temp.next != cycle) {
                if (temp.next == start) {
                    temp.next = null;
                    return;
                }
                temp = temp.next;
            }
            start = start.next;
        }
    }

    public void removeCycle2() {
        Node cycle = cycleNode();
        if (cycle == null) {
            return;
        }

        int count = 1;
        Node temp = cycle;
        while (temp.next != cycle) {
            count++;
            temp = temp.next;
        }

        Node fast = this.head;
        for (int i = 1; i <= count; i++) {
            fast = fast.next;
        }

        Node start = head;
        while (start.next != fast.next) {
            start = start.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    // ! This is the most optimised version for Removing cycle from a Linkes List
    public void FloydCycleRemoval() {
        Node cycle = cycleNode();
        if (cycle == null)
            return;

        Node fast = cycle;
        Node start = this.head;
        while (start.next != fast.next) {
            start = start.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    public void Display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }
    }
}
