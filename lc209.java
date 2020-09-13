//sliding window 
//https://www.youtube.com/watch?v=jKF9AcyBZ6E
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


//Solution II
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int val_sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            val_sum += nums[i];
            
            while (val_sum >= s) {
                res = Math.min(res, i + 1 - left);
                val_sum -= nums[left];
                left++;
            }
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}


//20200807
//20200808

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int i = 0; 
        int sum = 0;
        int res = Integer.MAX_VALUE;
        
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            
            while (sum >= s) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}