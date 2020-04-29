class Solution {
    public int missingNumber(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length * (nums.length + 1) / 2;
        
        for (int i : nums) {
            n -= i;
        }
        return n;
    }
}