//Solution I
//similar to 330
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        
        int[] dp = new int[nums.length];
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    len = Math.max(len, dp[j] + 1);
                    //if (len >= 3) return true;
                } 
            }
            dp[i] = len;
            maxLen = Math.max(maxLen, dp[i]);
        }
        if (maxLen >= 3) return true;
        else 
            return false;
    }
}


//Solution II
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= min1)
                min1 = i;
            else if (i <= min2)
                min2 = i;
            else 
                return true;
        }
        return false;
    }
}