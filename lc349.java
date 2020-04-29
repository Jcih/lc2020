class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i : nums1) {
            if (!map1.containsKey(i)) map1.put(i, i);
        }
        
        for (int i : nums2) {
            if (!map2.containsKey(i)) map2.put(i, i);
        }
        ArrayList<Integer> res = new ArrayList<Integer>(); 
        
        for (Map.Entry entry: map2.entrySet()) {
            if (map1.containsKey(entry.getKey())) {
                res.add((int)entry.getValue());
            } 
        }
        
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        
        return resArr;
    }
}



//Solution II
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int i : nums1) {
            set.add(i);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int j : nums2) {
            if (set.contains(j)) {
                res.add(j);
                set.remove(j);
            }
        }
        
        int[] myArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            myArray[i] = res.get(i);
        }
        
        return myArray;
    }
}