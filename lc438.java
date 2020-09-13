class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        
        List<Integer> res = new ArrayList<>();
        
        for (int i= 0; i <= s.length() - len; i++) {
            String s1 = s.substring(i, i + len);
            
            if (isAnagram(s1, p)) {
                res.add(i);
            }
        }
        return res;
    }
    
    
    
    private boolean isAnagram(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        else if (s1 == null || s2 == null) {
            return false;
        } else {
            if (s1.length() != s2.length()) {
                return false;
            } else {
                int[] arr = new int[26];
                for (int i = 0; i < s1.length(); i++) {
                    arr[s1.charAt(i) - 'a']++;
                    arr[s2.charAt(i) - 'a']--;
                }
                
                for (int j : arr) {
                    if (j != 0) {
                        return false;
                    }
                }
                return true;
                
            }
        }
    }
}



//Solution II
//sliding window
//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.