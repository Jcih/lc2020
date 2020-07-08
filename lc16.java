class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE; // min diff
        
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);
                
                if (diff == 0)
                    return target;
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
                    
                    
            }
        }
        return res;
    }
}