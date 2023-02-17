//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for (int i=0; i<V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }
        
        int vis[] = new int[V];
        int res = 0;
        
        for (int i=0; i<V; i++) {
            if (vis[i] == 0) {
                res++;
                dfs(adjList, vis, i);
            }
        }
        return res;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node) {
        vis[node] = 1;
        
        for (int nb : adj.get(node)) {
            if (vis[nb] == 0) {
                dfs(adj, vis, nb);
            }
        }
    }
};