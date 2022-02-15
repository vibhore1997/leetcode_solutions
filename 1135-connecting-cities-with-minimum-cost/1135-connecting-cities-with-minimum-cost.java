class Solution {
    
    private int findPar(int u, int[] parent) {
        if (u == parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }
    
    private void union(int u, int v, int[] rank, int[] parent) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        
        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[u] = v;
            rank[v]++;
        }
    }
    
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a,b) -> a[2] - b[2]);
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        int res = 0;
        int count = 0;
        
        for(int i=0; i<connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            
            if (findPar(u, parent) != findPar(v, parent)) {
                res += connections[i][2];
                count++;
                union(u,v,rank,parent);
            }
            if (count == n - 1) {
                break;
            }
        }
        
        // for (int i=0; i<=n; i++) {
        //     System.out.println("Parent of " + i + " -> " + parent[i]);
        //     System.out.println("Rank of " + i + " -> " + rank[i]);
        // }
        
        if (count >= n-1) {
            return res;
        } else {
            return -1;
        }
        
    }
}