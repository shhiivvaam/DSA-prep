import java.util.*;

public class Main {

    // ! Here we have used the DSU and Kruskal's Code

    // ! This is the Kruskal's Algorithm Code
    HashMap<Integer, HashMap<Integer, Integer>> map;

    // Graph Creation Code
    public Main(int v) {
        this.map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    // This is used to keep the track of all the edges with their costs
    // The approach is to keep the track of the edges with their cost, and at last
    // we will sort these pairs and then form the Graph of (MST)
    public class EdgePair {
        int e1; // edge 1
        int e2; // edge 2
        int cost; // edge cost

        public EdgePair(int e1, int e2, int cost) {
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }

        // This is used because, in the Answer we are getting the Address of the edges,
        // and we don't want that, we actually need the edges.
        @Override
        public String toString() {
            return "EdgePair [e1=" + e1 + ", e2=" + e2 + ", cost=" + cost + "]";
        }

        // @Override
        // public String toString() {
        // return e1 + "-" + e2 + "@" + cost;
        // }

    }

    // This will contain all the EdgePairs to keep track of the edges with their
    // costs
    public ArrayList<EdgePair> getAllEdges() {
        ArrayList<EdgePair> list = new ArrayList<>();

        for (int e1 : map.keySet()) {
            for (int e2 : map.get(e1).keySet()) {
                // This will lead to the addition of multiple duplicate edges: but we will
                // handle this in the implementation of Kruskal's algorithm, since here we are
                // just creating the Graph and implmentating the Structure of the track ofp
                // EdgePairs
                EdgePair ep = new EdgePair(e1, e2, map.get(e1).get(e2));
                list.add(ep);
            }
        }
        return list;
    }

    public void KruskalsAlgoritm() {

        // This will be used to keep track of the sum of the cost(edge weights) for the
        // Spannig Tree Formed after implementing the Kruskal's Algo
        int sum = 0;

        // Create that many number of sets, that the Vertex is present.
        DisJointSet dsu = new DisJointSet();
        for (int k : map.keySet()) {
            dsu.CreateSet(k);
        }

        ArrayList<EdgePair> ll = getAllEdges();

        // Since their is no default logic for the EdgePair Sorting, so we need to pass
        // out own comparator, to perform sorting
        Collections.sort(ll, new Comparator<EdgePair>() {

            @Override
            // public int compare(Main.EdgePair o1, Main.EdgePair
            // o2) {
            public int compare(EdgePair o1, EdgePair o2) {
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'compare'");

                return o1.cost - o2.cost;
            }
        });

        for (EdgePair edge : ll) {
            int e1 = edge.e1;
            int e2 = edge.e2;

            // here, the above duplicacy that is formed while forming the EdgePair is
            // handled automatically, since the EdgePairs represnetative element{RE} will be
            // the same, and so will come into same structure.

            int re1 = dsu.find(e1); // reperesentative element 1
            int re2 = dsu.find(e2); // reperesentative element 2

            // case 1
            if (re1 == re2) {
                // since we have the same RE, which means they are the same parent, and so we
                // need not to join it into any other set or RE(parent)
                // ! do nothing
            } else {
                System.out.println(edge);
                sum += edge.cost;
                dsu.union(re1, re2);
            }
        }
        System.out.println(sum);
    }

    // ! This is the DSU Code - DisJoint Set Unit

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

            // return find(nn.parent);

            // ! Insted of the above return : This is the Path Compression Step -> This
            // optimizes the Code
            Node n = find(nn.parent);
            nn.parent = n;
            return n;
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

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);

        // no. of vertex or ndoes
        int n = ask.nextInt();
        Main ks = new Main(n);

        // no. of edges
        int m = ask.nextInt();
        for (int i = 0; i < m; i++) {
            int v1 = ask.nextInt();
            int v2 = ask.nextInt();
            int cost = ask.nextInt();

            ks.addEdge(v1, v2, cost);
        }

        ks.KruskalsAlgoritm();
    }
}
