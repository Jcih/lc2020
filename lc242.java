//Solutino I
//20200811
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        if (s == null || t == null) return false;
        
        int[] ans = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++;
            ans[t.charAt(i) - 'a']--;
        }
        
        for (int i : ans) {
            if (i != 0)
                return false;
        }
        return true;
            
    }
}


//SolutionII
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map_s = new HashMap<>();
        
        if (s.length() != t.length()) 
            return false;
        else {
            
            for (int i = 0; i < s.length(); i++) {
                map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) + 1);
               
            }
        }
        
       for (int i = 0; i < t.length(); i++) {
           char c2 = t.charAt(i);
           if (map_s.containsKey(c2)) {
               if (map_s.get(c2) == 1)
                   map_s.remove(c2);
               else 
                   map_s.replace(c2, map_s.get(c2) - 1);
           } else {
               return false;
           }
       }
        
        if (map_s.size() > 0)
            return false;
        
        return true;
            
    }
}