class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] pat = pattern.toCharArray();
        String[] s_arr = str.split(" ");
        
        if (pat.length != s_arr.length) return false;
        
        HashMap<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < pat.length; i++) {
            
            if (map.containsKey(pat[i])) {
                if (!map.get(pat[i]).equals(s_arr[i]))
                    return false;
            } else {
                if (map.containsValue(s_arr[i]))
                    return false;
                map.put(pat[i], s_arr[i]);
            } 
        }
        
        return true;
    }
}



//20200822
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) return true;
        if (pattern == null || str == null) return false;
        
        String[] wordInStr = str.split(" ");
        if (wordInStr.length != pattern.length())
            return false;
        
        
        Map<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!wordInStr[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                if (map.containsValue(wordInStr[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), wordInStr[i]);
            }
        }
        return true;
    }
}