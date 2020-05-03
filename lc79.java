//https://www.youtube.com/watch?v=vYYNp0Jrdv0
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, int i, int j, int idx, String word) {
        if (idx == word.length()) {
            return true;
        }
        
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1 || board[i][j] != word.charAt(idx)) {
            return false;
        }
        
        char tmp = board[i][j];
        board[i][j] = ' ';
        boolean found = helper(board, i + 1, j, idx + 1, word) ||
            helper(board, i - 1, j, idx + 1, word) ||
            helper(board, i, j + 1, idx + 1, word) ||
            helper(board, i, j - 1, idx + 1, word);
        
        board[i][j] = tmp;
        return found;
            
    }
}