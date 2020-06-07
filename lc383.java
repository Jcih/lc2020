class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

//Solution II
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
                //continue;
            } else {
                return false;
            }
        }
        return true;
    }
}