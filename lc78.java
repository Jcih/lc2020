
//classic backtrack
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(path));

        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
}
