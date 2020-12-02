class Solution {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0) return board;
        
        int row = board.length;
        int col = board[0].length;
        boolean toCrash = false;  
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) { 
                int v = Math.abs(board[i][j]);
             
                if (i + 2 < row && v != 0 && v == Math.abs(board[i + 1][j]) && 
                   v == Math.abs(board[i + 2][j])) {
                    toCrash = true;
                    board[i][j] = -v;
                    board[i + 1][j] = -v;
                    board[i + 2][j] = -v;
                }
                
                if (j + 2 < col && v != 0 && v == Math.abs(board[i][j + 1]) &&
                   v == Math.abs(board[i][j + 2])) {
                    toCrash = true;
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                }
            }
        }
        
        if (toCrash){
            for (int i = 0; i < col; i++) {
                int start = row - 1;
                for (int j = row - 1; j >= 0; j--) {
                    if (board[j][i] > 0) {
                        board[start][i] = board[j][i];
                        start--;
                    }
                }
                while (start >= 0) {
                    board[start][i] = 0;
                    start--;
                }
            }   
        }     
        return toCrash ? candyCrush(board) : board;      
    }
}