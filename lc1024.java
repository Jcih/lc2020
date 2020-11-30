//https://massivealgorithms.blogspot.com/2019/04/leetcode-1024-video-stitching.html
//greedy
//45, 55, 1326
//1024
class Solution {
    public int videoStitching(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int count = 0;
        int cur_end = 0;
        
        for (int i = 0; i < clips.length;) {
            if (clips[i][0] > cur_end) return -1; // can't connect 
            
            int maxend = cur_end;// need to update the farest end
            while (i < clips.length && clips[i][0] <= cur_end) { // the start is before the current end, get the farest end
                maxend = Math.max(maxend, clips[i][1]); // get the father end under the condition of connectable
                i++;
            }
            
            count++;
            cur_end = maxend;
            if (cur_end >= T) {
                return count;
            }
            
        }
        return -1;
    }
}



// dp

class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, T + 1);
        dp[0] = 0;
        for (int i = 1; i <= T && dp[i - 1] < T; i++){
            for (int[] clip : clips) {
                if (clip[0] <= i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                } 
            }
        }
        return dp[T] == T + 1 ? -1 : dp[T];
     }
}