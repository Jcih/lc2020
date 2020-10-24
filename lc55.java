//https://www.youtube.com/watch?v=Zb4eRjuPHbM
//20200921
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (nums.length == 0 || nums == null)
            return true;
        
        int lastGoodIdx = nums.length - 1;
        
        for (int i = lastGoodIdx; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIdx)// means point i can reach the current reachable point
                lastGoodIdx = i;
        }
        return lastGoodIdx == 0;
    }
}