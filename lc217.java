//Solution I
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            if (map.containsKey(i)) {
                return true;
            } else {
                map.put(i, 1);
            }
                
        }
        return false;
    }
}

//Solution II
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int i : nums) {
            if (!seen.add(i)) return true;
        }
        return false;
    }
}


//Solution III 
class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        if (nums.length == 0 || nums == null) return false;
        
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}