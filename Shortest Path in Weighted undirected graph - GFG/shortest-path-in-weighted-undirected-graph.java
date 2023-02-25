//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair implements Comparable<Pair> {
    int first;
    int second;
    
    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
    
    @Override
    public int compareTo(Pair obj) {
        return this.first - obj.first;
    }
}

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i=0 ;i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i=0; i<edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];
            int w = edges[i][2];
            adj.get(s).add(new Pair(d, w));
            adj.get(d).add(new Pair(s, w));
        }
        
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        
        for (int i = 0; i<=n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> a.first - b.first);
        queue.offer(new Pair(0, 1));
        
        while (queue.size() != 0) {
            Pair pair = queue.poll();
            int distance = pair.first;
            int node = pair.second;
            
            for (Pair p : adj.get(node)) {
                int nb = p.first;
                int weight = p.second;
                
                if (distance + weight < dist[nb]) {
                    dist[nb] = distance + weight;
                    queue.offer(new Pair(dist[nb], nb));
                    parent[nb] = node;
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        if (parent[n] == n) {
            res.add(-1);
            return res;
        }
        
        res.add(n);
        int node = n;
        while (parent[node] != 1) {
            res.add(parent[node]);
            node = parent[node];
        }
        res.add(1);
        
        Collections.reverse(res);
        
        return res;
        
    }
}