import java.util.Random;
class Solution {

    int[] nums;
    Random rand;
    
    
    public Solution(int[] nums) {
    
        this.nums = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr = nums.clone();
        
        // need memorize
        for (int i = 1; i < arr.length; i++) {
            int j = rand.nextInt(i + 1);
            swap(arr, i, j);
        }
        return arr;
    }
    
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */