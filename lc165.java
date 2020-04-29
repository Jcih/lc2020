
//https://blog.csdn.net/crazy1235/article/details/51439523
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        int len1 = s1.length;
        int len2 = s2.length;
        
        int max = Math.max(len1, len2);
        for (int i = 0; i < max; i++) {
            
            int tmp1 = 0, tmp2 = 0;
            if (i < len1) {
                tmp1 = Integer.parseInt(s1[i]);
            }
            if (i < len2) {
                tmp2 = Integer.parseInt(s2[i]);
            }
            
            if (tmp1 > tmp2) {
                return 1;
            } else if (tmp1 < tmp2) {
                return -1;
            }
        }
        return 0;
        
    }
}