//https://www.youtube.com/watch?v=qBbZ3tS0McI

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0 , 0, n);
        return res;
    }
    
    private void backtrack(List<String> list, String s, int open, int close, int n) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        
        if (open < n) backtrack(list, s + "(", open + 1, close, n);
        if (close < open) backtrack(list, s + ")", open, close + 1, n);
    }
}