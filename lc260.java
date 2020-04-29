//Solution I
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        
        if (nums.length == 0 || nums == null) return res;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int index = 0;
        for (int j : nums) {
            if (map.get(j) == 1) {
                res[index] = j;
                index++;
            }
        }
        return res;
            
    }
}


//Solutin II
class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        int[] res = new int[2];
        int index = 0;
        
        for (int i : set) {
            res[index] = i;
            index++;
        }
        return res;
            
    }
}