import java.util.*;

public class Bipartite_Graph {
    // Bipartite Graph
    // Conditions:
    // 1. No Cycle
    // 2. If Cycle, then odd no of edges : Bipartite (Since then we cannot divide
    // the Vertexes into to equals)
    // even no of edges : Not-Bipartite (Since we can then divide the Vertexes into
    // two)

    // Conditons for Graph to be Bipartite :
    // The graph has no cycles of odd length
    // Every edge belongs to an odd number of bonds
    // The vertices in one set are not connected to vertices in the same set
    // There are no self-loops or multiple edges between the same pair of vertices
    // A graph is bipartite if and only if all its circuits are even. For example, a
    // triangle has an odd length circuit, so it cannot be bipartite

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = ask.nextInt();

        int[][] graph = new int[row][];
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter the number of columns in: " + i + 1 + " row : ");
            int col = ask.nextInt();

            // Creating a new Array for the current row
            graph[i] = new int[col];
        }

        // Taking Input in the 2D Jagged Array
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.println("Enter the value for row " + i + 1 + " & column " + j + 1 + " :");
                graph[i][j] = ask.nextInt();
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.println("The Graph is : ");
        if (isBipartite(graph))
            System.out.println("Bipartite");
        else
            System.out.println("Not Bipartite");
    }

    // Pair Class responsibe for keeping the track of the currently visiting and
    // last visited vertex in the Graph: for cycle Detection in the Graph
    public class BipartitePair {
        // vertex
        int vtx;
        // distacne
        int d;

        public BipartitePair(int vtx, int d) {
            this.vtx = vtx;
            this.d = d;
        }
    }

    static boolean isBipartite(int[][] graph) {

        // Suiting the Input format of the Leetcode Question(Is Graph Bipartite?) with
        // the Graph Structure
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            map.put(i, new HashMap<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) { // since it's a jagged array -> {graph[i].length}
                map.get(i).put(graph[i][j], 1); // marking vertex 'i' is connected to 'graph[i][j]' with some random
                                                // cost {i.e, 1 here}
            }
        }

        return isBipartite(map);
    }

    // The below code is same as the BFT code : just the change is in the { Ignore
    // step } and the addition of the Bipartite Pair for (chekcking the visiting
    // nodes i.e, the last visited and currently visiting node)
    static boolean isBipartite(HashMap<Integer, HashMap<Integer, Integer>> map) {
        // The below linked list is made up of the Pair Class {BipartitePair}
        LinkedList<BipartitePair> q = new LinkedList<>();

        // Takign the visited to be a HashMap, since now we need to check the vertex
        // with their distance, i.e, the parameters of the BipartitePair
        HashMap<Integer, Integer> visited = new HashMap<>();

        for (int src : map.keySet()) { // This loop is responsible to for the traversal to all the Graphs present
            if (visited.containsKey(src)) { // This steps helps not do all the same work for the earlier visited Graph
                continue;
            }

            BipartitePair bp = new BipartitePair(src, 0);

            q.add(bp);
            while (!q.isEmpty()) {

                // remove
                BipartitePair r = q.remove();

                // Ignore if already present
                if (visited.containsKey(r.vtx) && r.d != visited.get(r.vtx)) {
                    return false; // The Graph is not Bipartite
                }

                // mark visited
                visited.put(r.vtx, r.d);

                // add neighbours
                for (int nbrs : map.get(r.vtx).keySet()) { // r.vtx : the Bipartite Vertex
                    if (!visited.containsKey(nbrs)) {
                        BipartitePair nbp = new BipartitePair(nbrs, r.d + 1); // last remove BipartitePair (distance) +1

                        // Intead of adding the neighbours, now adding the Bipartite Pair
                        q.add(nbp);
                    }
                }
            }
        }
        // Always Bipartite : if it goes out of the loop(since it means the we are not
        // able to find any odd length cycle, or same current and last visited extreme
        // points(vertex))
        return true;
    }
}