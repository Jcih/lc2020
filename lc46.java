
// classic backtrack
// similar with #131 and #93 , #17

//Solution I   O(n) = n * n!
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }
    
    public static void helper(List<List<Integer>> res, List<Integer> cur, int[] nums) {
    
        
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            helper(res, cur, nums);
            cur.remove(cur.size() - 1);   // why?
        }
    }
}


//Solution II O(N) = n!
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(int[] nums, int from, List<Integer> cur, List<List<Integer>> allList) {
        if(cur.size() == nums.length) {
            allList.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = from; i < nums.length; ++i) {
            swap(nums, from , i);
            cur.add(nums[from]);
            helper(nums, from + 1, cur, allList);
            cur.remove(cur.size() - 1);
            swap(nums, from, i);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}