class Solution {
    public int lengthOfLastWord(String s) {
        
        if (s == null || s.length() < 1)
            return 0;
        
        String[] c_arr = s.split("\\s+");
        
        if (c_arr.length == 0)
            return 0;
        
        int res = c_arr[c_arr.length - 1].length();
        return res;
    }
}