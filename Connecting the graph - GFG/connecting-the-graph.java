//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    int parent[];
    int rank[];
    
    public int findPar(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = findPar(parent[u]);
    }
    
    public void union(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if (pu == pv) return;
        
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }

    public int Solve(int n, int[][] edge) {
        int m = edge.length;
        
        if (m < n-1) return -1;
        parent = new int[n];
        rank = new int[n];
        
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        for (int i=0; i<edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            
            union(u,v);
        }
        
        int comp = 0;
        
        for (int i=0; i<n; i++) {
            if (i == parent[i]) comp++;
        }
        
        return comp - 1;
    }
}