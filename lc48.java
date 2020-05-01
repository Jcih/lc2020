//https://www.youtube.com/watch?v=SA867FvqHrM
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        
        int N = matrix.length;
        
        //transpose
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        
        //flip horizonally
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (N/2); j++) {
                int tmp = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = matrix[i][j];
                matrix[i][j] =  tmp;
                
            }
        }
    }
}