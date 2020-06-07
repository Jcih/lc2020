

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




//Solutin II
//whenever have a new value, set index value
class Solution {
	public int removeDuplicates(int[] nums) {
		int index = 1;
		for (int i = 0; i< nums.length - 1; i ++) {
			if (nums[i] != nums[i + 1])
				nums[index++] = nums[i + 1];
		}
		return index;
	}
}