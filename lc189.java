//https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51462800
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k , nums.length - 1);
    }
                
    private void reverse(int[] nums, int m, int n) {
        while (m < n) {
            int temp = nums[m];
            nums[m++] = nums[n];
            nums[n--] = temp;
        }


    }
}