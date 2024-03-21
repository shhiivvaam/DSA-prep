import java.util.*;

public class Graph {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Graph(int v) { // v -> vertex
        this.map = new HashMap<>();

        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public boolean ContainsEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);

        // This is also correct, and we need not to check for the second condition as
        // mentioned above.
        // return map.get(v1).containsKey(v2);
    }

    public boolean ContainsVertex(int v) {
        return map.containsKey(v);
    }

    public int numberOfEdge() {
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key).size();
        }
        return sum / 2;
    }

    public void removeEdge(int v1, int v2) {
        if (ContainsEdge(v1, v2)) {
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
    }

    public void removeVertex(int v) {
        if (ContainsVertex(v)) {
            for (int key : map.get(v).keySet()) {
                // removeEdge(key, v);
                map.get(key).remove(v);
            }
            map.remove(v);
        }
    }

    public void display() {
        for (int key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
    }

    public boolean hasPath(int src, int dest, HashSet<Integer> visited) {
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

    public void printAllPath(int src, int dest, HashSet<Integer> visited, String str) {
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

}