class Solution {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    
    boolean isValid(int x, int y, int r, int c) {
        if(x < 0 || y < 0 || x >= r || y >= c) return false;
        return true;
    }
    
    public int numEnclaves(int[][] grid) {
        for(int i=0; i<grid[0].length; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
            if (grid[grid.length - 1][i] == 1) {
                dfs(grid, grid.length - 1, i);
            }
        }
        
        for(int i = 1; i < grid.length - 1; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(grid, i, grid[0].length - 1);
            }
        }
        
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        
        for(int i=0; i<4; i++) {
            int nbx = x + dx[i];
            int nby = y + dy[i];
            if (isValid(nbx, nby, grid.length, grid[0].length) && grid[nbx][nby] == 1) {
                dfs(grid, nbx, nby);
            }
        }
    }
}