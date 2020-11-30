//https://github.com/cherryljr/LeetCode/blob/master/Jump%20Game%20II.java
//greedy
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        
        return jumps;
    }
}



//greeady
class Solution {
    public int jump(int[] nums) {
        int end = 0, farCanReach = 0, count = 0;
        for (int i = 0; end < nums.length - 1; end = farCanReach ) {
            count++;
            while (i < nums.length && i <= end) {
                farCanReach = Math.max(farCanReach, i + nums[i]);
                i++;
            }
            if (end == farCanReach) return -1;
        }
        return count;
    }
}