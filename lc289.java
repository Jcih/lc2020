//https://www.youtube.com/watch?v=9AsUixzUGa0

class Solution {
    
    //die -> live: -1
    //live -> die: 2
    
    final static int[][] dir = {{0, -1}, {0,1}, {1, -1}, {1, 0}, {1,1}, {-1, 0}, {-1, 1}, {-1, -1}};
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 0) {
                    int lives = count(board, i, j);
                    if (lives == 3) {
                        board[i][j] = -1;
                    }
                } else { // board[i][j] == 1
                    int lives = count(board, i, j);
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 2;
                    }
                }
                                
            }
        }
        update(board);
    }
    
    //update board
    private void update(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1)
                    board[i][j] = 1;
                else if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }
    

    //count live neighbours
    private int count(int[][] board, int row, int col) {
        int res = 0;
        for (int[] d : dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 & newCol < board[0].length && (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)) {
                res++;
            }
        }
        
        return res;
    }
}