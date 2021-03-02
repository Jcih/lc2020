class Solution {
    int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) return board;
        
        int row = click[0], col = click[1];
        
        char c = board[row][col];
        if (c == 'M') {
            board[row][col] = 'X';
        } else {
            updateDFS(board, row, col);
        }
        
        return board;
    }
    
    
    
    private void updateDFS(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') return;
        int mineNum = countAdjMines(board, x, y);
        
        if (mineNum > 0) {
            board[x][y] = (char) (mineNum + '0');
        } else {
            board[x][y] = 'B';
            for (int[] d : dirs) {
                updateDFS(board, x + d[0], y + d[1]);
            }
        }
    }
    
    
    
    private int countAdjMines(char[][] board, int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'M')
                    count++;
            }
        }
        return count;
    }
    
    
    
}