class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i : nums) {
            set.add(i);
        }
        
        int res = 1;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int count = 1;
                
                while(set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}