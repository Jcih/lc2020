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