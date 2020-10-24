//20200921
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int bot = n - 1;
        int left = 0;
        int right = n - 1;
        int count = 1;
        
        while (count <= n * n) {
            for (int i = left; i <= bot && count <= n * n; i++) {
                res[top][i] = count;
                count++;
            }
            top++;
            
            for (int i = top; i <= bot && count <= n * n; i++) {
                res[i][right] = count;
                count++;
            }
            right--;
            
            for (int i = right; i >= left && count <= n * n; i--) {
                res[bot][i] = count;
                count++;
            }
            bot--;
            
            for (int i = bot; i >= top && count <= n * n; i--) {
                res[i][left] = count;
                count++;
            }
            left++;
            
        }
        return res;
    }
}