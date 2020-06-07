//credit: https://mlixin.com/2019/11/26/leetcode-386/
//https://leetcode.com/problems/lexicographical-numbers/discuss/86231/Simple-Java-DFS-Solution
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            lexicalOrder(n, i, result);
        }
        return result;
    }
    
    public void lexicalOrder(int n, int pre, List<Integer> res) {
        if (pre <= n) {
            res.add(pre);
            for (int i = 0; i < 10; i++) {
                int next = pre * 10 + i;
                if (next > n) {
                    return;
                }
                lexicalOrder(n, next, res);
            }
        }
    }
}