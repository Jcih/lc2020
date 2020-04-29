class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        if (s == null || s.length() == 0)
            return res;
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (!set.contains(c))
                set.add(c);
        }
        
        boolean single = false;
        
        for (char ch : set) {
            if (map.get(ch) % 2 == 0) {
                res += map.get(ch);
            } else if(map.get(ch) >= 2) {
                res += (map.get(ch) - 1);
                single = true;
            } else if (map.get(ch) == 1) {
                single = true;
            }
        }
        
        if (single) {
            res++;
        }
        return res;
    }
}