//20200923
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0)
            return res;
        
        helper(res, n, k, new ArrayList(), 1);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int n, int k, List<Integer> cur, int idx) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        
        for (int i = idx; i <= n; i++) {
            //if ()
            cur.add(i);
            helper(res, n, k, cur, i + 1);
            cur.remove(cur.size() - 1);
            
        }
    }
}