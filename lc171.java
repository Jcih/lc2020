class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        char[] c = s.toCharArray();
        int res = 0;
        
        for (Character i : c) {
            int tmp = i - 'A' + 1;
            res = res * 26 + tmp;
        }
        return res;
    }
}