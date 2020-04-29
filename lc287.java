
//Brute force Solution I, very slow
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                return entry.getKey();
        }
        return 0;
    }
}

//Solution II, O(n), T(n), faster than 47%
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        Set<Integer> set = new HashSet<>();
        
        for (int i : nums) {
            if (set.contains(i))
                return i;
            else {
                set.add(i);
            }
        }
        return -1; 
    }
}

//Solution III
// credit  https://www.programcreek.com/2015/06/leetcode-find-the-duplicate-number-java/
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
        } while (slow != fast);
        
        int find = 0;
        while (find != slow) {
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}



