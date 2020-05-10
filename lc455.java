class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        
        int i = 0;
        int j = 0;
        
        int g_size = g.length;
        int s_size = s.length;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        while (i < g_size && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return res;
    }
}