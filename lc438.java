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
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> result = new LinkedList<>();
        if(p.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == p.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }
}




//SOlution III sliding window by two arrays 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < p.length()) return res;
        int[] phash = new int[26];
        int[] shash = new int[26];
        int window = p.length();
        int left = 0;
        int right = 0;
        
        while (right < window) {
            phash[p.charAt(right) - 'a']++;
            shash[s.charAt(right) - 'a']++;
            right++;
        }
        
        right--;
        while (right < s.length()) {
            if (Arrays.equals(phash, shash)) {
                res.add(left);
            }
            right++;
            if (right != s.length()) {
                shash[s.charAt(right) - 'a']++;
            }
            shash[s.charAt(left) - 'a']--;
            left++;

        }
        return res;
    
    }
}