

//Solution I using extra space
class Solution {
    public void moveZeroes(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 0);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[index] = nums[i];
                index++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
        
    }
}



//Solution II
class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
            
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                cnt++;
            else {
                nums[i - cnt] = nums[i];
            }
        }
        
        for (int j = nums.length - cnt; j < nums.length; j++)
            nums[j] = 0;
        
    }
}


//Solution III
//https://www.youtube.com/watch?v=0rPuILjoVsg
class Solution {
    public void moveZeroes(int[] nums) {

        int anc = 0;
        
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] != 0) {
                int tmp = nums[anc];
                nums[anc] = nums[i];
                nums[i] = tmp;
                anc++;
            }
        }
    }
}