class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (nums.length == 0 || nums == null)
            return res;
        Arrays.sort(nums);
        
        helper(nums, res, cur, 0);
        return res;
              
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, int idx ) {
             
        res.add(new ArrayList<Integer>(cur));
        
        for (int i = idx; i < nums.length; i++) {
           if (i == idx || nums[i] != nums[i - 1]) {
                cur.add(nums[i]);
                helper(nums, res, cur, i + 1); // attention: i + 1, not idx + 1
                cur.remove(cur.size() - 1);
            }
        }
     
    }
}

