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
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1)
            set1.add(i);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int j : nums2) {
            if (set1.contains(j)) {
                res.add(j);
                set1.remove(j);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}




//Solutino III
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1)
            set1.add(i);
        
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2)
            set2.add(i);
        
        set1.retainAll(set2);
        
    
        int idx = 0;
        int[] arr = new int[set1.size()];
        for (int k : set1) {
            arr[idx++] = k;
        }
        return arr;
    }
}

//Solution IV
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        
        for (int i : nums1) {
            set1.add(i);
        }
        
        Set<Integer> res = new HashSet<>();
        for (int j : nums2) {
            if (set1.contains(j)) {
                res.add(j);
            }
        }
        
        int n = res.size();
        int[] ans = new int[n];
        int idx = 0;
        for (int i : res) {
            ans[idx] = i;
            idx++;
        }
        return ans;
    }
}