class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int min = Integer.MAX_VALUE;
        
        for (int i : nums) {
            min = Math.min(i, min);
        }
        return min;
    }
}


//https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51525714
//Solutino II binary search
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right])
                right = mid;
            else 
                left = mid + 1;
        }
        return nums[right];
    }
}