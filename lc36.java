class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return false;
        
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set_row = new HashSet<>();
            HashSet<Character> set_col = new HashSet<>();
            HashSet<Character> set_cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!set_row.add(board[i][j]))
                        return false;
                }
                if (board[j][i] != '.') {
                    if (!set_col.add(board[j][i]))
                        return false;
                }
                

                /////dont understand this part// to get cube position
                int rowIdx = 3 * (i / 3) + j / 3;
                int colIdx = 3 * (i % 3) + j % 3;
                /////


                if (board[rowIdx][colIdx] != '.') {
                    if (!set_cube.add(board[rowIdx][colIdx])) 
                        return false;
                }
            }
        }
        return true;
        
        
        
        
    }
}