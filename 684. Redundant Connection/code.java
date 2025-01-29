import java.util.*;

public class code {
    public static int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        int v = edges.length;
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

            if (isCycle(v, adj)) {
                return edge;
            }
        }
        return new int[0];
    }

    public static boolean isCycle(int v, List<List<Integer>> adj) {
        boolean[] vis = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            if (!vis[i]) {
                if (dfs(adj, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, boolean[] vis, int node, int parent) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(adj, vis, it, node)) {
                    return true;
                }
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] result = findRedundantConnection(new int[][]{
            {1, 2},
            {1, 3},
            {2, 3}
        });

        System.out.println(Arrays.toString(result));
    }
}
