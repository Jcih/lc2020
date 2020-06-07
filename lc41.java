class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i : nums) {
            set.add(i);
        }
        
        int k = nums.length + 1;
        for (int i = 1; i <= k; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}


//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_41.java
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
            
        }
        for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}