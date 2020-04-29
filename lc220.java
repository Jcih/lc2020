//https://www.cnblogs.com/271934Liao/p/7521536.html



//credit https://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0  || k < 0 || t < 0) return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long curr = (long) nums[i];
            long left = (long) curr - t;
            long right = (long) curr + t + 1;
            SortedSet<Long> sub = treeSet.subSet(left, right);
            if (sub.size() > 0)
                return true;
            treeSet.add(curr);
            if (i >= k)
                treeSet.remove((long) nums[i-k]);
        }
        return false;
    }
}

//solution II
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] num, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < num.length; i++) {
            Integer ceil = set.ceiling(num[i]);
            if(ceil != null && ceil <= t + num[i]) {
                return true;
            }
                
            Integer floor = set.floor(num[i]);
            if(floor != null && num[i] <= t + floor) {
                return true;
            }
            
            set.add(num[i]);
            if(set.size() > k) {
                set.remove(num[i-k]);
            }
        }
        return false;
    }

}