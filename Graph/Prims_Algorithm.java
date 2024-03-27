import java.util.*;

public class Prims_Algorithm {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Prims_Algorithm(int v) {
        this.map = new HashMap<>();

        for (int i = 0; i < v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost); // v1 -> map get kra then put v2 and cost
        map.get(v2).put(v1, cost); // similarily for v2 : v2 -> map get kra then put v1 and cost
    }

    public class PrimsPair {
        int vtx; // vertex
        int acqvtx; // acquiring vertex
        int cost; // cost

        public PrimsPair(int vtx, int acqvtx, int cost) {
            this.vtx = vtx; // this is the current vertex(node)
            this.acqvtx = acqvtx; // this is the connected vertex to which the current vertex is connected to
            this.cost = cost; // this is the cost betweeen the current vertex and the acquiring vertex
                              // (edge weight)
        }

        @Override
        public String toString() {
            return "PrimsPair [vtx=" + vtx + ", acqvtx=" + acqvtx + ", cost=" + cost + "]";
        }

        // @Override
        // public String toString() {
        // return this.vtx + " via " + this.acqvtx + " @ " + this.cost;
        // }
    }

    public void PrimsAlgo() {

        int sum = 0;
        // PriorityQueue<PrimsPair> pq = new PriorityQueue<>(); // here we cannot
        // directly pass the Priority Queue, since we are not doing any comparison,so we
        // need a Comparator to perform some comparison

        // min HEAP -> Priority Queue
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {

            @Override
            public int compare(PrimsPair p1, PrimsPair p2) {
                return p1.cost - p2.cost;
            }
        });
        HashSet<Integer> visited = new HashSet<>();

        pq.add(new PrimsPair(1, 1, 0)); // start from vertex 1 with no cost -> randomly

        while (!pq.isEmpty()) {
            PrimsPair pp = pq.remove();

            // steps:
            // 1.ignore
            // 2.visited
            // 3.print
            // 4. add nbrs (neighbours)

            // ignore
            if (visited.contains(pp.vtx))
                continue;

            // visited
            visited.add(pp.vtx);

            // print
            System.out.println(pp);
            sum += pp.cost;

            // nbrs
            for (int nbrs : map.get(pp.vtx).keySet()) {
                if (!visited.contains(nbrs)) {
                    PrimsPair np = new PrimsPair(nbrs, pp.vtx, map.get(pp.vtx).get(nbrs));
                    pq.add(np);
                }
            }
        }

        System.out.println("Total Sum :" + sum);
    }

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int n = ask.nextInt();

        Prims_Algorithm p = new Prims_Algorithm(n);
        int m = ask.nextInt();

        for (int i = 0; i < m; i++) {
            int v1 = ask.nextInt();
            int v2 = ask.nextInt();
            int cost = ask.nextInt();

            p.AddEdge(v1, v2, cost);
        }

        p.PrimsAlgo();

        ask.close();
    }
}