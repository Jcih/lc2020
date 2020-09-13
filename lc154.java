class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid]  > nums[hi]) {
             // min is in the right side
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--; // deal with the duplicates
            }
        }
        return nums[lo];
    }
}