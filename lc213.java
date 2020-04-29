//credit : https://blog.csdn.net/mine_song/article/details/70196507
class Solution {
    public int rob(int[] nums) {
        if (nums == null) 
            return 0;
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robDP(nums, 0, n - 2), robDP(nums, 1, n - 1));
    }
    
    int robDP(int[] nums, int first, int last) {
        int n = last - first  + 1;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[first];
        
        int[] dp = new int[n];
        dp[0] = nums[first];
        
        dp[1] = Math.max(nums[first], nums[first + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[first + i], dp[ i - 1]);
            
        }
        return dp[n - 1];
    }
}