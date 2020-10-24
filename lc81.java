//20200928
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return false;
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            
            if (nums[mid] > nums[left]) {
                    //pivot is on right

                    if (nums[mid] >= target && nums[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
            } else if (nums[mid] < nums[left]) {

                    // pivot is on left

                    if (nums[mid] <= target && nums[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    } 
            } else {      //diff from #33
                left++;
            }
        } 
        return false;
    
    }
}