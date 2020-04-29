

// did 2 times
class Solution{
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums ==null) return 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[res] != nums[i]) {
				res++;
				nums[res] = nums[i];
			}
		}
		return res + 1;
	}
}