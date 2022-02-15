class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        
        for(int i=0; i<n; i++) {
            if (vis[i] == -1) {
                if (check(i, 1, graph, vis) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check(int node,int val, int[][] graph, int[] vis) {
        vis[node] = val;
        
        for(int i : graph[node]) {
            if (vis[i] == -1) {
                // val = 1 - val;
                if (check(i, 1 - val, graph, vis) == false) {
                    return false;
                }
            } else if (vis[i] == val) {
                return false;
            }
        }
        return true;
    }
}