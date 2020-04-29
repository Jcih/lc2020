class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
            }
        }
        
        int[] res = new int[list.size()];
        
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        
        return res;
    }
}