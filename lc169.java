//Solution I
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}



//Solution II, Moore Voting Algorithm, faster than 100%. need review, didn't understand.
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
          if (count == 0) {
            count++;
            majority = nums[i];
          } else if (nums[i] == majority) {
            count++;
          } else {
            count--;
          }
        }
        return majority;
    }


//Solution III
class Solution {
    public int majorityElement(int[] nums) {
        int k = nums.length / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int  n : nums) {
            if (map.get(n) > k)
                return n;
        }
        return -1;
    }
}