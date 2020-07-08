//https://leetcode.com/problems/diagonal-traverse-ii/discuss/597698/JavaC%2B%2B-HashMap-with-Picture-Clean-code-O(N)
//FACEBOOK
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return null;
        }
        
        int count = 0;
        int maxKey = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                map.putIfAbsent(i + j, new ArrayList());
                map.get(i + j).add(nums.get(i).get(j));
                count++;
                maxKey = Math.max(maxKey, i + j);
            }
        }
        
        int[] res = new int[count];
        int j = 0;
        for (int key = 0; key <= maxKey; key++) {
            List<Integer> value = map.get(key);
            if (value == null) continue;
            //reverse order
            for (int i = value.size() - 1; i >= 0; i--) {
                res[j++] = value.get(i);
            }
        }
        return res;
    }
}