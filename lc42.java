class Solution {
	public int trap(int[] height) {
		if (height == null || height.length <= 2) {
			return 0;
		}
		int max = height[0];
		int maxIdx = 0;

		//find the max height idx
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				maxIdx = i;
			}
		}


		int water = 0;
		int leftMax = height[0];
		for (int i = 0; i < maxIdx; i++) {
			if (height[i] < leftMax) {
				water += leftMax - height[i];
			} else {
				leftMax = height[i];
			}
		}

		int rightMax = height[height.length - 1];
		for (int j = height.length - 1; j > maxIdx; j--) {
			if (height[j] < rightMax) {
				water += rightMax - height[j];
			} else {
				rightMax = height[j];
			}
		}
		return water;
	}
}