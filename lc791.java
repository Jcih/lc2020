//FACEBOOK
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map_S = new HashMap<>();
        
        int[] map = new int[26];
        for (char c : T.toCharArray()) {
            map[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char sc : S.toCharArray()) {
            while (map[sc - 'a'] > 0) {
                sb.append(sc);
                map[sc - 'a']--;
            }
        }
        
        for (char c = 'a'; c <= 'z'; c++) {
            while (map[c - 'a'] > 0) {
                sb.append(c);
                map[c - 'a']--;
            }
        }
        return sb.toString();
        
    }
}