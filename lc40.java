//https://www.youtube.com/watch?v=IER1ducXujU
//backtrack
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList(), 0, target, candidates);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int index, int target, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0)
            return;
        
        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                curr.add(candidates[i]);
                helper(res, curr, i + 1, target - candidates[i], candidates);
                curr.remove(curr.size() - 1);
            }
        }
    }
}