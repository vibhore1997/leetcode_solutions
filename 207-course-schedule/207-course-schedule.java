class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] vis = new int[numCourses];
        int[] dfsvis = new int[numCourses];
        
        for(int i=0; i<numCourses; i++) {
            if (vis[i] == 0) {
                if (isCycle(graph, vis, dfsvis, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isCycle(List<List<Integer>> graph, int[] vis, int[] dfsvis, int i) {
        vis[i] = 1;
        dfsvis[i] = 1;
        
        for(int ele : graph.get(i)) {
            if (vis[ele] == 0) {
               if (isCycle(graph, vis, dfsvis, ele)) {
                return true;
                } 
            } else if (dfsvis[ele] == 1) {
                return true;
            }
        }
        dfsvis[i] = 0;
        return false;
    }
}