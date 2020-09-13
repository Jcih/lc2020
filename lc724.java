class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int sum = 0;
        for (int i : nums)
            total += i;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum * 2 == total + nums[j]) {// sum += nums[j] will perform after
                return j;
            }
        }
        return -1;
    }
}