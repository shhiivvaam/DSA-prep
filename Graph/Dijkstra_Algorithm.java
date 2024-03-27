import java.util.*;

public class Dijkstra_Algorithm {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Dijkstra_Algorithm(int v) {
        this.map = new HashMap<>();

        for (int i = 0; i < v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public class DijkstraPair {
        int vtx; // vertex
        String acqPath; // All the acquiring vertexes
        int cost; // cost

        public DijkstraPair(int vtx, String acqPath, int cost) {
            this.vtx = vtx; // this is the current vertex(node)
            this.acqPath = acqPath; // these will be all the connected vertexes(Path) to which the current vertex is
                                    // connected to
            this.cost = cost; // this is the cost betweeen the current vertex and the acquiring vertex
                              // (edge weight)
        }

        @Override
        public String toString() {
            return "PrimsPair [vtx=" + vtx + ", acqPath=" + acqPath + ", cost=" + cost + "]";
        }

        // @Override
        // public String toString() {
        // return this.vtx + " via " + this.acqPath + " @ " + this.cost;
        // }
    }

    public void Dijkstra() {
        // PriorityQueue<PrimsPair> pq = new PriorityQueue<>(); // here we cannot
        // directly pass the Priority Queue, since we are not doing any comparison,so we
        // need a Comparator to perform some comparison

        // min HEAP -> Priority Queue
        PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<DijkstraPair>() {

            @Override
            public int compare(DijkstraPair p1, DijkstraPair p2) {
                return p1.cost - p2.cost;
            }
        });

        HashSet<Integer> visited = new HashSet<>();

        pq.add(new DijkstraPair(1, "1", 0));
        while (!pq.isEmpty()) {
            DijkstraPair dp = pq.remove();

            if (visited.contains(dp.vtx)) {
                continue;
            }
            visited.add(dp.vtx);

            System.out.println(dp);

            for (int nbrs : map.get(dp.vtx).keySet()) {
                if (!visited.contains(nbrs)) {
                    int c = dp.cost + map.get(dp.vtx).get(nbrs); // cost
                    DijkstraPair ndp = new DijkstraPair(nbrs, dp.acqPath + nbrs, c);
                    pq.add(ndp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Dijkstra_Algorithm da = new Dijkstra_Algorithm(8);
        da.AddEdge(1, 2, 2);
        da.AddEdge(2, 3, 3);
        da.AddEdge(1, 4, 10);
        da.AddEdge(4, 5, 8);
        da.AddEdge(3, 4, 1);
        da.AddEdge(5, 6, 5);
        da.AddEdge(5, 7, 6);
        da.AddEdge(6, 7, 4);

        da.Dijkstra();
    }
}
