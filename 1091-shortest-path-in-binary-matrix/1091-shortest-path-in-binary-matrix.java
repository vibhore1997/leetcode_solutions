class Solution {
    int dx[] = {1,-1,0,0,1,1,-1,-1};
    int dy[] = {0,0,1,-1,-1,1,1,-1};
    
    boolean isValid(int x, int y, int r, int c) {
        if (x < 0 || y < 0 || x >= r || y >= c) return false;
        return true;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
                                    
        Queue<int[]> queue = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        
        if (grid[0][0] == 1 || grid[r-1][c-1] == 1) {
            return -1;
        }
                                    
        boolean visited[][] = new boolean[r][c];
        
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        boolean flag = false;
        
        
        while (queue.size() != 0) {
            int[] coord = queue.poll();
            
            if (coord[0] == r-1 && coord[1] == c - 1) {
                flag = true;
                return coord[2];
            }
            
            for(int i=0; i<8; i++) {
                int nbx = coord[0] + dx[i];
                int nby = coord[1] + dy[i];
                
                if (isValid(nbx, nby, r, c) && !visited[nbx][nby] && grid[nbx][nby] == 0) {
                    queue.offer(new int[]{nbx, nby, coord[2] + 1});
                    visited[nbx][nby] = true;
                }
            }
        }
        
        if (flag == false) {
            return -1;
        }
        return 0;
    }
}