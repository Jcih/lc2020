class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return result;
        
        int k = nums.length / 3;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > k) {
                result.add(entry.getKey());
            }
        }
        return result;
        
    }
}