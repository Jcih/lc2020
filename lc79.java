//https://www.youtube.com/watch?v=vYYNp0Jrdv0
//https://www.youtube.com/watch?v=m9TrOL1ETxI
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
    
    //dfs
    private boolean helper(char[][] board, int i, int j, int idx, String word) {
        
        //stop condition, word iteration comes to end
        if (idx == word.length()) {
            return true;
        }
        
        //corner cases, i, j not valid, char not equal
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1 || board[i][j] != word.charAt(idx)) {
            return false;
        }
        
        //process if valid
        char tmp = board[i][j];
        board[i][j] = ' ';// make this posisition void for this round
        

        boolean found = helper(board, i + 1, j, idx + 1, word) ||
            helper(board, i - 1, j, idx + 1, word) ||
            helper(board, i, j + 1, idx + 1, word) ||
            helper(board, i, j - 1, idx + 1, word);
        
        board[i][j] = tmp;//make this position valid again for other iterations
        return found;
            
    }
}

// why not using boolean[][] visited, because every position only need to be void for its own round checking; 

//For iteration it will be valid again.