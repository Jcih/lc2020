class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) count++;
        }
        
        return count <= 1;
    }
}