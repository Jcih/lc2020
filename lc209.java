//sliding window 
// credit : https://www.programcreek.com/2014/05/leetcode-minimum-size-subarray-sum-java/
//https://www.cnblogs.com/grandyang/p/4501934.html

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        
        int i = 0;
        int j = 0;
        int sum = 0;

        
        while (j < nums.length) {
            if (sum >= s) {
                minLen = Math.min(minLen, j - i);
                if (i == j - 1)
                    return 1;
                sum -= nums[i];
                i++;
            } else {
                
                sum = sum + nums[j];
                j++;
            }
        }
        
        while (sum >= s) {
            minLen = Math.min(minLen, j - i);
            sum -= nums[i++];
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
        
        
    }
}