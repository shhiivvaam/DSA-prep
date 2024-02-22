import java.util.*;

public class HashMap<K, V> {
    public class Node {
        K key;
        V value;
        Node next;

        public Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Node> buckeyArr;
    private int size = 0;

    public HashMap(int x) {
        this.buckeyArr = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            this.buckeyArr.add(null);
        }
    }

    public HashMap() {
        this(4);
    }

    public void put(K key, V value) {
        int bn = hashfunction(key);
        Node temp = this.buckeyArr.get(bn); // 1st Address

        while (temp != null) {
            if (temp.key.equals(key)) { // here we cannot do { temp.key == key } because it will then check the address
                                        // of the key
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        Node nn = new Node(key, value);
        nn.next = this.buckeyArr.get(bn); // making { nn } to the first address
        nn.next = temp;
        this.buckeyArr.set(bn, nn);
        this.size++;

        // Rehashing
        double lf = (1.0 * this.size) / this.buckeyArr.size(); // lf -> load Factor
        double thf = 2.0; // thf -> threshold factor

        if (lf > thf) {
            rehashing();
        }
    }

    private void rehashing() {
        ArrayList<Node> nba = new ArrayList<>(); // bna -> new bucket Array
        for (int i = 0; i < 2 * this.buckeyArr.size(); i++) {
            nba.add(null);
        }
        ArrayList<Node> oba = this.buckeyArr;
        this.buckeyArr = nba;
        this.size = 0;

        for (Node node : oba) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public V get(K key) {
        int bn = hashfunction(key);
        Node temp = this.buckeyArr.get(bn); // 1st Address
        while (temp != null) {
            if (temp.key.equals(key)) { // here we cannot do { temp.key == key } because it will then check the address
                                        // of the key
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public V remove(K key) {
        int bn = hashfunction(key);
        Node curr = this.buckeyArr.get(bn); // 1st Address
        Node prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) { // here we cannot do { temp.key == key } because it will then check the address
                                        // of the key
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if (curr == null)
            return null;

        this.size++;
        if (prev == null) { // this means that the node to be deleted was the first node only
            this.buckeyArr.set(0, curr.next);
            curr.next = null;
        } else { // this means that we need to delete some middle node
            prev.next = curr.next;
            curr.next = null;
        }
        return curr.value;
    }

    @Override
    public String toString() {
        String s = "{";

        for (Node node : this.buckeyArr) {
            while (node != null) {
                s += node.key + " = " + node.value + ", ";
                node = node.next;
            }
        }
        s += "}";
        return s;
    }

    public boolean containsKey(K key) {
        int bn = hashfunction(key);
        Node temp = this.buckeyArr.get(bn); // 1st Address
        while (temp != null) {
            if (temp.key.equals(key)) { // here we cannot do { temp.key == key } because it will then check the address
                                        // of the key
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int hashfunction(K key) {
        int bn = key.hashCode() % this.buckeyArr.size();

        // if the generated bucket no is negative;
        if (bn < 0) {
            bn += this.buckeyArr.size();
        }
        return bn;
    }

}
