import java.util.*;

public class BellmanFord_Algorithm {
    // * 1. It is used to check that wheather the Graph contains any negative
    // weighted
    // Cycle or not.
    // * 2. We will make the edges rest (V-1) times, here V is the total number of
    // Vertices.

    HashMap<Integer, HashMap<Integer, Integer>> map;

    public BellmanFord_Algorithm(int v) {
        this.map = new HashMap<>();
        for (int i = 0; i < v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost); // v1 ->v2 mai Edge and cost
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
                // This will automatically handle the Duplicates here, since we are implementing
                // the Bellman Ford Algo
                EdgePair ep = new EdgePair(e1, e2, map.get(e1).get(e2));
                list.add(ep);
            }
        }
        return list;
    }

    public void BellmanFordAlgo() {

        int v = map.size();
        int[] dsu = new int[v + 1];

        for (int i = 2; i <= v; i++) {
            dsu[i] = 100000000; // we have taken this much greater number but not the INTEGER MAX VALUE :
                                // because while doing the operations, adding some value to the INTEGER MAX
                                // VALUE makes the value out of range but this {100000000} not.
        }

        ArrayList<EdgePair> list = getAllEdges();
        for (int i = 1; i <= v; i++) {
            for (EdgePair ep : list) {
                int e1 = ep.e1;
                int e2 = ep.e2;
                int oldCost = dsu[e2];
                int newCost = dsu[e1] + ep.cost;

                if (i == v && newCost < oldCost) {
                    System.out.println("-ve Weight Cycle is present.");
                    return;
                }
                if (oldCost > newCost) {
                    dsu[e2] = newCost;
                }
            }
        }

        for (int i = 1; i < dsu.length; i++) {
            System.out.println(dsu[i] + " ");
        }
    }

    public static void main(String[] args) {
        BellmanFord_Algorithm bf = new BellmanFord_Algorithm(6);
        bf.AddEdge(1, 2, 8);
        // bf.AddEdge(2, 5, -2); // This was used to check, whether the Bellman Ford
        // Algo is able to detect the Negative Weight Cycle
        bf.AddEdge(2, 5, 2);
        bf.AddEdge(5, 2, 1);
        bf.AddEdge(4, 5, 4);
        bf.AddEdge(3, 4, -3);
        bf.AddEdge(1, 3, 4);
        bf.AddEdge(1, 4, 5);

        bf.BellmanFordAlgo();
    }
}
