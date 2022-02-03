// class Solution {
//     int minSum = Integer.MAX_VALUE;
    
//     int[] dx = {0,1};
//     int[] dy = {1,0};
    
//     boolean isValid (int x, int y, int r, int c) {
//         if (x >= r || y >= c) return false;
//         return true;
//     }
    
//     public int minPathSum(int[][] grid) {
//         helper(0,0,grid,0);
//         return minSum;
//     }
    
//     void helper(int x, int y, int[][] grid, int sum) {
//         sum += grid[x][y];
        
//         if (sum >= minSum) {
//             return;
//         }
        
//         if (x == grid.length -1 && y == grid[0].length - 1) {
//             if (sum < minSum) {
//              minSum = sum;   
//             }
//             return;
//         }
        
//         for (int i = 0; i<2; i++) {
//             int nbx = x + dx[i];
//             int nby = y + dy[i];
            
//             if (isValid(nbx, nby, grid.length, grid[0].length)) {
//                 helper(nbx, nby, grid, sum);
//             }
//         }
//     }
// }

class Solution {
    
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
        
    }
}