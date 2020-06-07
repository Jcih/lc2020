class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(ch[i]) == 1) {
                return i;
            } 
        }
        return -1;
    }
}



//Solution II
class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}