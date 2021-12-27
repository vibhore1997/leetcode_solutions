class Solution {
    int dx[] = {0,0,1,-1};
    int dy[] = {1,-1,0,0};
    int initial;
    
    private boolean isValid(int x, int y, int r, int c) {
        if(x < 0 || y < 0 || x >= r || y >= c) return false;
        return true;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        initial = image[sr][sc];
        if (initial == newColor) {
            return image;
        }
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int color) {
        image[x][y] = color;
        
        for(int i=0; i<4; i++) {
            int nbx = x + dx[i];
            int nby = y + dy[i];
            if (isValid(nbx, nby, image.length, image[0].length) && image[nbx][nby] == initial) {
                dfs(image, nbx, nby, color);
            }
        }
    }
}