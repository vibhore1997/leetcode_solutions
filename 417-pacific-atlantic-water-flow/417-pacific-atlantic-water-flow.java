class Solution {
    boolean pac = false;
    boolean atl = false;
    
    boolean isValid(int x, int y, int r, int c) {
        if (x < 0 || y < 0 || x >= r || y >= c) return false;
        return true;
    }
    
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[][] map = new boolean[heights.length][heights[0].length];
        
        for (int i=0; i<heights.length; i++) {
            for(int j=0; j<heights[0].length; j++) {
                pac = false;
                atl = false;
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                dfs(i, j, heights, map, visited);
                if (pac && atl) {
                    map[i][j] = true;
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    
    private void dfs(int x, int y, int[][] grid, boolean[][] map, boolean[][] visited) {
        visited[x][y] = true;
        if (map[x][y] == true) {
            pac = true;
            atl = true;
            return;
        }
        if (x == 0 || y == 0) {
            pac = true;
        }
        if (x == grid.length - 1 || y == grid[0].length - 1) {
            atl = true;
        }
        
        for (int i=0; i<4; i++) {
            int nbx = x + dx[i];
            int nby = y + dy[i];
            
            if (isValid(nbx, nby, grid.length, grid[0].length) && !visited[nbx][nby] 
                && grid[nbx][nby] <= grid[x][y]) {
                
                dfs(nbx, nby, grid, map, visited);
                
                if (pac && atl) {
                    return;
                }
                
            }
        }
    }
}