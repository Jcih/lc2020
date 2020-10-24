//https://www.youtube.com/watch?v=uvB-Ns_TVis
//20200922
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int start = 0;
        int end = nums.length - 1;
        int idx = 0;
        
        while (idx <= end && start <= end) {
            if(nums[idx] == 0) {
                nums[idx] = nums[start];
                nums[start] = 0;
                idx++;
                start++;
            } else if(nums[idx] == 2) {
                nums[idx] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                idx++;
            }
            
        }
    }
}