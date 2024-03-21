import java.util.*;

public class Graph_Valid_Tree {

    // ? For this condition to happend: (to check the given Graph is a Valid Tree )
    // * 1. No cycle : The Graph should not contain cycle
    // * 2. Connected : The Graph should not be dis-connected
    public static void main(String[] args) {
        int[][] graph = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        int n = 4;
        System.out.println(isValidTree(graph, n));
    }

    static boolean isValidTree(int[][] graph, int n) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());

            // ! Doing this : we need not to perform the addition { for loop } we used below
            // this loopadded to the
            // map.put(graph[i][0], new HashMap<>());
            // map.put(graph[i][1], new HashMap<>());
        }

        for (int i = 0; i < graph.length; i++) {
            int v1 = graph[i][0];
            int v2 = graph[i][1];

            map.get(v1).put(v2, 1); // here 1 is the cost } and since there is not work of cost here in the ques, so
                                    // we have putted it as { 1 }
            map.get(v2).put(v1, 1);
        }

        return isTree(map);
    }

    static boolean isTree(HashMap<Integer, HashMap<Integer, Integer>> map) {
        // To check wheather a Graph is a Tree or Not:
        // 1. The Graph should not be disconnected
        // 2. The Graph should not contain Cycle

        // Using the BFT Approach
        // Queue
        LinkedList<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();

        int count = 0;
        for (int src : map.keySet()) {
            if (visited.contains(src)) {
                continue;
            }
            count++;
            if (count > 1)
                return false; // means the loop has ran more than once, and so the Graph must be disconnected

            q.add(src);
            while (!q.isEmpty()) {
                int r = q.remove();

                if (visited.contains(r)) {
                    return false;
                }

                visited.add(r);

                for (int nbrs : map.get(r).keySet()) {
                    if (!visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
        }

        return count == 1; // means the loop hai only run once: and so the Graph is connected and not
                           // di-sconnected
    }

}
