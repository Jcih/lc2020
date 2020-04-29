class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(result, curr, k,  1, n);
        return result;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int k, int start, int sum) {
        if (sum < 0)
            return;
        if (sum == 0 && curr.size() == k) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            helper(res, curr, k, i + 1, sum - i);
            curr.remove(curr.size() - 1);
        }
    }
    
}