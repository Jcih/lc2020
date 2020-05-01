//https://www.youtube.com/watch?v=qKczfGUrFY4
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> res = new ArrayList<>();
        int[] cur_interval = intervals[0];
        res.add(cur_interval);
        
        for (int[] interval : intervals) {
            int curr_begin = cur_interval[0];
            int curr_end = cur_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            
            if (curr_end >= next_begin) {
                cur_interval[1] = Math.max(curr_end, next_end);
            } else {
                cur_interval = interval;
                res.add(interval);
            }
        }
        
        return res.toArray(new int[res.size()][]);
        
        
    }
}