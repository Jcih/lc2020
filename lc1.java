class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index1 = i;
                int index2 = map.get(target - nums[i]);
                res[0] = index1;
                res[1] = index2;
                return res;
            }
            
            map.put(nums[i], i);
        }
        
        return res;
    }
}