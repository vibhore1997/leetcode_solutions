class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row[] = new HashSet[9];
        Set<Character> col[] = new HashSet[9];
        Set<Character> box[] = new HashSet[9];
        
        for(int i=0; i<9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        
        for (int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (board[i][j] != '.') {
                    
                    if (!row[i].add(board[i][j])) {
                        return false;
                    }
                    
                    if (!col[j].add(board[i][j])) {
                        return false;
                    }
                    
                    int indexBox = (i/3)*3 + (j/3);
                    if (!box[indexBox].add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}