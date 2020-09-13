class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        String[] arr = s.split("\\s+");
        
        int res = 0;
        for (String t : arr) {
            if (t.length() >= 1) {
                res++;
            }
        }
        return res;
    }
}