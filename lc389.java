class Solution {
    public char findTheDifference(String s, String t) {
        
        char c = 0;
        int i = 0;
        int n = t.length();
        
        while (i < n - 1) {
            c += t.charAt(i) - s.charAt(i);
            i++;
        }
        
        c += t.charAt(n - 1);
        return c;
    }
}