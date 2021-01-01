//https://leetcode.com/problems/set-intersection-size-at-least-two/discuss/113086/Hope-you-enjoy-this-problem.-%3A-)-O(NlogN)JavaGreedy-Easy-to-understand-solution

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int res = 0;
        if (intervals == null || intervals.length == 0) return res;
        
        //sort according to the endpoint in ascending order , if two intervals has same endpoint, sort them according to the start point in descending order
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        
        
        int left = intervals[0][1] - 1;
        int right = intervals[0][1];
        res += 2;
        
        for (int[] cur : intervals) {
            if (right < cur[0]) {
                //no element in the interval
                left = cur[1] - 1;
                right = cur[1];
                res += 2;
            } else if (left < cur[0] && right >= cur[0]) {
                //one element in the interval
                res++;
                left = right;
                right = cur[1];
            }
        }
        return res;
    }
}