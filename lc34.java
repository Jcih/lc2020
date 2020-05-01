class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] {-1, -1};
        
        //find a target number 
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
                
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        
        //from the target, look for left and right
        if (index != -1) {
            left = index;
            right = index;
            while (left >= 0 && nums[left] == target) {
                left--;
            }
            while (right < nums.length && nums[right] == target) {
                right++;
            }
        } else {
            return new int[] {-1, -1};
        }
        
        int[] res = new int[2];
        res[0] = left + 1;
        res[1] = right - 1;
        
        return res;
    }
}