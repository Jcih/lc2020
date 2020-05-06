//https://www.youtube.com/watch?v=pD3cHFNyW2I

class Solution {
    public int maxLength(List<String> arr) {
       
        //StringBuilder sb = new StringBuilder();        
        int[] res = new int[1];
        helper("", 0, arr, res);
                
        return res[0];
    }
    
    public void helper(String cur, int idx, List<String> arr, int[] res) {
         if (idx == arr.size() && uniqueCharCount(cur) > res[0]) {
            res[0] = cur.length();
            return;
        }
        
        if (idx == arr.size()) {
            return;
        }
 
        helper(cur, idx + 1, arr, res);
        helper(cur + arr.get(idx), idx + 1, arr, res);
    }
    
    public int uniqueCharCount(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            if (count[c - 'a']++ > 0) {
                return -1;
            }
        }
        return s.length();
    }
    
}