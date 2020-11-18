class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    cur.add(nums[k]);
                    res.add(cur);
                    j++;
                    k--;
                }
                                                            
            }
        }
        return res;
    }
}


// Wrong codes
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        
        Arrays.sort(nums);
        
        helper(nums, 0, new ArrayList<>(), res, 0);
        
        return res;
    }
    
    public void helper(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res, int target) {
        if (idx > nums.length - 1)
            return;
        if (target == 0 && cur.size() == 3) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            helper(nums, idx + 1 ,cur, res, target - nums[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
