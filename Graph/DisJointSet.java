public class DisJointSet {

    // It mainly contains 3 operations:
    // 1. Create Set
    // 2. Merge/ Union
    // 3. Find Set

    public class Node {
        int val;
        int rank;
        Node parent;
    }

    public HashMap<Integer, Node> map = new HashMap<>();

    public void CreateSet(int v) {
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.parent = nn;
        map.put(v, nn);
    }

    public int find(int v) {
        Node nn = map.get(v);
        return find(nn).val;
    }

    private Node find(Node nn) { // this will return the address of the representative Node
        if (nn.parent == nn) {
            return nn;
        }
        return find(nn.parent);
    }

    public void union(int v1, int v2) {
        Node n1 = map.get(v1);
        Node n2 = map.get(v2);
        Node rn1 = find(n1); // rn1 -> rank of Node 1
        Node rn2 = find(n2); // rn1 -> rank of Node 2

        // case 1
        if (rn1.rank == rn2.rank) {
            rn1.parent = rn2;
            // rn1.rank++;
            rn2.rank = rn2.rank + 1;
        }
        // case 2
        else if (rn1.rank > rn2.rank)
            rn2.parent = rn1;
        // case 3
        else
            rn1.parent = rn2;
    }
}
