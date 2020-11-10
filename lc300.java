class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            maxLen = Math.max(maxLen, dp[i]);
            
        }
        return maxLen;
    }
}



//20201029
//similar with 1048
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        int res = 0;
        
        for (int i =0 ; i < n; i++) {
            
            int maxLen = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, 1 + dp[j]);
                }
            }
            dp[i] = maxLen;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}