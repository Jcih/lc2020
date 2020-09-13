//20200807
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {            
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}




//Solution II
//https://leetcode.com/problems/maximal-square/discuss/61802/Extremely-Simple-Java-Solution-%3A)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] dp = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        //dp[i][j] represents the length of the square which lower right corner is located at (i, j).
                        //If the value of this cell is also 1, then the length of the square is the minimum of: the one above, its left, and diagonal up-left value +1. 
                        //Because if one side is short or missing, it will not form a square.
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;//why min()????
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
                
            }
        }
        return ans * ans;
        
        
    }
}