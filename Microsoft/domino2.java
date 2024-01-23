package Microsoft;
import java.util.*;

public class domino2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] =  {5, 1, 2, 6, 6, 1, 3, 1, 4, 3, 4, 3, 4, 6, 1, 2, 4, 1, 6, 2};
		int[][] pair= new int[a.length/2][2];
		for(int i = 0;i<a.length;i= i+2) {
			pair[i/2][0] = a[i];
			pair[i/2][1] = a[i+1];
		}
		Solution solution = new Solution();
        //int[][] pairs = {{5, 1}, {2, 6}, {6, 1}, {3, 1}, {4, 3}, {4, 3}, {4, 6}, {1, 2}, {4, 1}, {6, 2}};
//		int ans = find(a);
//		System.out.println(ans);
		int maxSequenceLength = solution.maxPairSequenceLength(pair);
        System.out.println("Maximum pair sequence length: " + maxSequenceLength);

	}

}

class Solution {
    private Map<Integer, List<Integer>> graph;

    public int maxPairSequenceLength(int[][] pairs) {
        buildGraph(pairs);

        int maxSequenceLength = 0;

        // Perform DFS for each node in the graph
        for (int node : graph.keySet()) {
            boolean[] visited = new boolean[graph.size() + 1];
            maxSequenceLength = Math.max(maxSequenceLength, dfs(node, visited));
        }

        return maxSequenceLength;
    }

    private void buildGraph(int[][] pairs) {
        graph = new HashMap<>();

        // Create a graph based on the pairs
        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }

    private int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int maxLength = 0;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                maxLength = Math.max(maxLength, 1 + dfs(neighbor, visited));
            }
        }

        visited[node] = false;  // Reset visited status for backtracking
        return maxLength;
    }
}