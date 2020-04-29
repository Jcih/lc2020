class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = s1.length - 1; i >= 0; i--) {
            sb.append(s1[i] + " ");
        }
        
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
}