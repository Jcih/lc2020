//https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/100754/Java-Binary-Search-short-(7l)-O(log(n))-w-explanations
class Solution {
    public int singleNonDuplicate(int[] nums) {
        /*
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] == nums[mid - 1] && (mid % 2) == 1) {
               
                //first half length is even, target is in end half
                left = mid + 1;
 
            } else if (nums[mid] == nums[mid + 1] && (mid % 2) == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        return nums[left];
        */
        // corner case
		if(nums == null || nums.length == 0) return -1;
        
        int lo = 0;
		int hi = nums.length - 1;
		while(lo < hi){
			int mid = lo + (hi - lo)/2;
						   
			if(mid % 2 == 0){
				// mid is even
				if(nums[mid] == nums[mid + 1]){
					lo = mid + 2;
				}else{
					hi = mid;
				}
			}else{
				// mid is odd
				if(nums[mid] == nums[mid - 1]){
					lo = mid + 1;
				}else{
					hi = mid;
				}
			}

		}
		return nums[lo];
    }
}