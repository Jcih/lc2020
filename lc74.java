class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int i = 0;
        int j = matrix[0].length - 1;
        
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}


//https://leetcode.com/problems/search-a-2d-matrix/discuss/26219/Binary-search-on-an-ordered-matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0) return false;
        int left = 0; 
        int right = matrix.length * matrix[0].length - 1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            int mid_value = matrix[mid / matrix[0].length][mid % matrix[0].length]; // memorize
            
            if (target == mid_value) return true;
            else if (target < mid_value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    
    }
}