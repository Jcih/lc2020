//https://www.youtube.com/watch?v=Zb4eRjuPHbM
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (nums.length == 0 || nums == null)
            return true;
        
        int lastGoodIdx = nums.length - 1;
        
        for (int i = lastGoodIdx; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIdx)
                lastGoodIdx = i;
        }
        return lastGoodIdx == 0;
    }
}