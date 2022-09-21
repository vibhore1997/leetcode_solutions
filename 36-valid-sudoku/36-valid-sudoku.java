class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row[][] = new int[9][9];
        int col[][] = new int[9][9];
        int box[][] = new int[9][9];
        
        for (int i=0; i< 9; i++) {
            for (int j=0; j<9; j++) {
                
                if (board[i][j] != '.') {
                   int b = i/3 + j/3 + (i/3)*2;
                    
                   int val = board[i][j] - '0' - 1;
                    
                    if (row[i][val] != 0)
                        return false;
                    
                    row[i][val] = 1;
                    
                    if (col[j][val] != 0) {
                        return false;
                    }
                    
                    col[j][val] = 1;
                    
                    if (box[b][val] != 0) {
                        return false;
                    }
                    
                    box[b][val] = 1;
                }
                
                
            }
        }
        
        return true;
    }
}