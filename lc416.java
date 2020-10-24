//Solution I, backtrack Time Limit Exceeded
//https://www.youtube.com/watch?v=5gpIN9Yf7C4
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) return false;
        
        sum /= 2;
        Arrays.sort(nums);
        
        
        return helper(nums, sum, 0);
        
    }
    
    private boolean helper(int[] nums, int target, int index) {
        if (target == 0) return true;
        if (index == nums.length || target < 0) return false;
        if (helper(nums, target - nums[index], index + 1)) return true;
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        return helper(nums, target, j);
    }
}


//Solution II dp, 不懂
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) return false;
        
        sum /= 2;
       
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= 0; j--) {
                if (j >= num) {
                    dp[j] = dp[j] || dp[j - num];    
                }
                
            }
        }
        return dp[sum];
        
    }
    
    
}