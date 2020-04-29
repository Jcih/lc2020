class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s == null || s.length() == 0) return true;
        
        int index_s = 0;
        int index_t = 0;
        
        while (index_s < s.length() && index_t < t.length()) {
            if (s.charAt(index_s) == t.charAt(index_t)) {
                
                if (index_s == s.length() - 1) return true;
                index_s++;
                index_t++;
            } else {
                index_t++;
            }
        }
        return false;
        
    }
}