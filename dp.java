//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems



//1027 facebook dp
//GOOGLE FACEBOOK
//http://www.noteanddata.com/leetcode-1027-Longest-Arithmetic-Sequence-Google-Interview-Problem-java-solution-note.html
//https://leetcode.com/problems/longest-arithmetic-sequence/discuss/274611/JavaC%2B%2BPython-DP
class Solution {
    public int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}