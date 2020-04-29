//did 2 times
class Solution {
	public int removeElement(int[] nums, int val) {
		// java array has no remove() method
		// length of array : nums.length, no bracket

		if (nums == null || nums == 0) return 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {

			//find the first element which != val , put it to the first place
			if (nums[i] != val) {
				nums[res] = nums[i];
				res++;
			}
		}
		return res;
	}
}