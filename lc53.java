//dp

class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        int max  = nums[0];
        sum[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}




//Solution II 
// 20200717 This problem should be medium 

public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(A[i] + dp[i - 1] , A[i]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}