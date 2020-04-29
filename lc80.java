class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int res = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[res - 2] != nums[i]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}