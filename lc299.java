//https://blog.csdn.net/styshoo/article/details/51166829
class Solution {
    public String getHint(String secret, String guess) {
        int cntA = 0, cntB = 0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        
        int[] nums = new int[10];
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) cntA++;
            else {
                if (nums[s[i] - '0']++ < 0) cntB++;
                if (nums[g[i] - '0']-- > 0) cntB++;
            }
        }
        return cntA + "A" + cntB + "B";
    }
}