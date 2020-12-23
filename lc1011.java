//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/256729/JavaC%2B%2BPython-Binary-Search
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        //binary search
        int left = 0, right = 0;
        
        for (int i : weights) {
            left = Math.max(left, i);
            right += i;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int needDays = 1;
            int curWeight = 0;
            for (int w : weights) {
                if (curWeight + w > mid) {
                    needDays++;
                    curWeight = 0;
                 }
                 curWeight += w;
            }
            
            if (needDays > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}