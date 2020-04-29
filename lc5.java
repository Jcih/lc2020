
//http://www.goodtecher.com/leetcode-5-longest-palindromic-substring/
//不懂
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        int left = 0;
        int right = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerWordPalin = dp[i + 1][j - 1] || j - i <= 2;
                if (s.charAt(i) == s.charAt(j) && isInnerWordPalin) {
                    dp[i][j] = true;
                    
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        
        return s.substring(left, right + 1);
        
        //Time O(n^2)
        //Space O(n^2)
    }
}