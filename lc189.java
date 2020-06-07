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


//Solution II
// Extra space
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for (int i = nums.length - 1; i > nums.length - k - 1; i--) {
            stack1.push(nums[i]);
        }
        
        for (int i = nums.length - k - 1; i >= 0; i--) {
            stack2.push(nums[i]);
        }
        
        int j = 0;
        while (j < nums.length && !stack1.isEmpty()) {
            nums[j] = stack1.pop();
            j++;
        }
        while (j < nums.length && !stack2.isEmpty()) {
            nums[j] = stack2.pop();
            j++;
        }
        
      
    }
}