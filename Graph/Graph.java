import java.util.*;

public class Graph {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    Graph(int v) { // v -> vertex
        this.map = new HashMap<>();

        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    boolean ContainsEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);

        // This is also correct, and we need not to check for the second condition as
        // mentioned above.
        // return map.get(v1).containsKey(v2);
    }

    boolean ContainsVertex(int v) {
        return map.containsKey(v);
    }

    int numberOfEdge() {
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key).size();
        }
        return sum / 2;
    }

    void removeEdge(int v1, int v2) {
        if (ContainsEdge(v1, v2)) {
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
    }

    void removeVertex(int v) {
        if (ContainsVertex(v)) {
            for (int key : map.get(v).keySet()) {
                // removeEdge(key, v);
                map.get(key).remove(v);
            }
            map.remove(v);
        }
    }

    void display() {
        for (int key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
    }

    boolean hasPath(int src, int dest, HashSet<Integer> visited) {
        if(src == dest) return true;

        visited.add(src);
        for(int nbrs: map.get(src).keySet()) {
            if(!visited.contains(nbrs)) {
                boolean ans = hasPath(nbrs, dest) 
                if(ans == true) return ans;
            }
        }
        visited.remove(src);
        return false;
    }

    void printAllPath(int src, int dest, HashSet<Integer> visited, String str) {
        if (src == dest) {
            System.out.println(str + src);
            return;
        }

        visited.add(src);
        for (int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                printAllPath(nbrs, dest, visited, str + src + " ");
            }
        }
        visited.remove(src);
    }

    // ? Breath First Search
    // steps:
    // 1. remove
    // 2. Ignore
    // 3.visited
    // 5. work
    // 5. nbrs add
    public boolean BFS(int src, int dest) {
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.add(src);
        while (!q.isEmpty()) {

            // remove
            int r = q.remove();

            // Ignore if already present
            if (visited.contains(r)) { // * this step is used to detect cycle in the graph
                continue; // * If we encounter with a node that is already visited then, it means that
                          // * there is a cycle in the graph
            }

            // mark visited
            visited.add(r); // * If checking for a -> b then should not check b -> a

            // work
            if (r == dest)
                return true;

            // add neighbours
            for (int nbrs : map.get(r).keySet()) {
                if (!visited.contains(nbrs)) {
                    q.add(nbrs);
                }
            }
        }
        return false;
    }

    // ? Depth First Search
    // steps:
    // 1. remove
    // 2. Ignore
    // 3.visited
    // 5. work
    // 5. nbrs add
    public boolean DFS(int src, int dest) {
        Stack<Integer> s = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        s.push(src);
        while (!s.isEmpty()) {

            // remove
            int r = s.pop();

            // Ignore if already present
            if (visited.contains(r)) { // * this step is used to detect cycle in the graph
                continue; // * If we encounter with a node that is already visited then, it means that
                          // * there is a cycle in the graph
            }

            // mark visited
            visited.add(r); // * If checking for a -> b then should not check b -> a

            // work
            if (r == dest)
                return true;

            // add neighbours
            for (int nbrs : map.get(r).keySet()) {
                if (!visited.contains(nbrs)) {
                    s.push(nbrs);
                }
            }
        }
        return false;
    }

    // ? Breadth First Traversal
    // steps:
    // 1. remove
    // 2. Ignore
    // 3.visited
    // 5. work
    // 5. nbrs add

    // BFT : This is used when we have to Traverse more then one
    // graphs{non-connected}
    public void BFT() {
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int src : map.keySet()) { // This loop is responsible to for the traversal to all the Graphs present
            if (visited.contains(src)) { // This steps helps not do all the same work for the earlier visited Graph
                continue;
            }

            q.add(src);
            while (!q.isEmpty()) {

                // remove
                int r = q.remove();

                // Ignore if already present
                if (visited.contains(r)) { // * this step is used to detect cycle in the graph
                    continue; // * If we encounter with a node that is already visited then, it means that
                              // * there is a cycle in the graph
                }

                // mark visited
                visited.add(r); // * If checking for a -> b then should not check b -> a

                // work
                System.out.println(r + " ");

                // add neighbours
                for (int nbrs : map.get(r).keySet()) {
                    if (!visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
        }
    }

    // ? Depth First Traversal
    // steps:
    // 1. remove
    // 2. Ignore
    // 3.visited
    // 5. work
    // 5. nbrs add

    // BFT : This is used when we have to Traverse more then one
    // graphs{non-connected}
    public void DFT() {
        Stack<Integer> s = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int src : map.keySet()) {
            if (visited.contains(src)) {
                continue;
            }

            s.push(src);
            while (!s.isEmpty()) {

                // remove
                int r = s.pop();

                // Ignore if already present
                if (visited.contains(r)) { // * this step is used to detect cycle in the graph
                    continue; // * If we encounter with a node that is already visited then, it means that
                              // * there is a cycle in the graph
                }

                // mark visited
                visited.add(r); // * If checking for a -> b then should not check b -> a

                // work
                System.out.println(r + " ");

                // add neighbours
                for (int nbrs : map.get(r).keySet()) {
                    if (!visited.contains(nbrs)) {
                        s.push(nbrs);
                    }
                }
            }
        }
    }

    // Checking if there is a Cycle in the Graph
    public boolean hasCycle() {
        // here we can used either of the BFT/ DFT code, any of them will work the same
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int src : map.keySet()) { // This loop is responsible to for the traversal to all the Graphs present
            if (visited.contains(src)) { // This steps helps not do all the same work for the earlier visited Graph
                continue;
            }

            q.add(src);
            while (!q.isEmpty()) {

                // remove
                int r = q.remove();

                // Ignore if already present
                if (visited.contains(r)) { // * this step is used to detect cycle in the graph
                    return true; // * If we encounter with a node that is already visited then, it means that
                                 // * there is a cycle in the graph
                }

                // mark visited
                visited.add(r); // * If checking for a -> b then should not check b -> a

                // add neighbours
                for (int nbrs : map.get(r).keySet()) {
                    if (!visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
        }
        return false;
    }

    // Checking if the Graph is connected or Not
    public boolean isConnected() {
        // here we can used either of the BFT/ DFT code, any of them will work the same
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        int count = 0; // if the loop runs more than once, the value of the count will increase and, if
                       // { the count value rises more than 0 } means the loop runs more than once, and
                       // so the Graph is diconnected(and has more than One Graph rather than a Single
                       // Graph)
        for (int src : map.keySet()) { // This loop is responsible to for the traversal to all the Graphs present
            if (visited.contains(src)) { // This steps helps not do all the same work for the earlier visited Graph
                continue;
            }

            count++;
            if (count > 1)
                return false; // means the loop has ran more than once, and so the Graph must be disconnected

            q.add(src);
            while (!q.isEmpty()) {

                // remove
                int r = q.remove();

                // Ignore if already present
                if (visited.contains(r)) { // * this step is used to detect cycle in the graph
                    return true; // * If we encounter with a node that is already visited then, it means that
                                 // * there is a cycle in the graph
                }

                // mark visited
                visited.add(r); // * If checking for a -> b then should not check b -> a

                // add neighbours
                for (int nbrs : map.get(r).keySet()) {
                    if (!visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
        }
        return count == 1; // means the loop hai only run once: and so the Graph is connected and not
        // dis-connected
    }

    boolean isTree(HashMap<Integer, HashMap<Integer, Integer>> map) {
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
                           // dis-connected
    }
}