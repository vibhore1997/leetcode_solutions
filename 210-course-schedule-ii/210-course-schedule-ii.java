class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] vis = new int[numCourses];
        int[] dfsvis = new int[numCourses];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numCourses; i++) {
            if (vis[i] == 0) {
                if (isCycle(graph, vis, dfsvis, i, stack)) {
                    return new int[0];
                }
            }
        }
        
        int[] res = new int[numCourses];
        int k = 0;
        while (stack.size() != 0) {
            res[k++] = stack.pop();
        }
        return res;
        
    }
    
    private boolean isCycle(List<List<Integer>> graph, int[] vis, int[] dfsvis, int i, Stack<Integer> stack) {
        vis[i] = 1;
        dfsvis[i] = 1;
        
        for(int ele : graph.get(i)) {
            if (vis[ele] == 0) {
               if (isCycle(graph, vis, dfsvis, ele, stack)) {
                return true;
                } 
            } else if (dfsvis[ele] == 1) {
                return true;
            }
        }
        dfsvis[i] = 0;
        stack.push(i);
        return false;
    }
}