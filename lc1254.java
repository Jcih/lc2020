//1254
class Solution {
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        if (row < 2 || col < 2) return 0;
        
        int count = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] == 0 && dfs(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }
    /*
    when using && (logical operator), it will short circuit, 
    meaning that it will stop reading/evaluating conditions after 
    the first one to be false. With & (bitwise), 
    the behavior is the same as logical operator EXCEPT that it won't short circuit.
    */
    public boolean dfs(int i, int j, int[][] grid) {
        
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) return false;
        
        if ((i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) && grid[i][j] == 0) return false;
        
        if (grid[i][j] == 1 || grid[i][j] == 2) return true;
        
        grid[i][j] = 2;
        boolean res = true;
        res = res & dfs(i + 1, j, grid) &
                        dfs(i - 1, j, grid) & 
                      dfs(i, j + 1, grid) &
                      dfs(i, j - 1, grid);
        
        return res;
    }
    
}