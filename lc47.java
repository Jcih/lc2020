class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null)
            return res;
        Arrays.sort(nums);
        
        boolean[] visited = new boolean[nums.length];
        helper(res, new ArrayList(), visited, nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, boolean[] visited, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            cur.add(nums[i]);
            helper(res, cur, visited, nums);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}