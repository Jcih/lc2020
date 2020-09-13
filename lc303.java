//20200725 care about corner case


class NumArray {

    int[] sum; //declare
    public NumArray(int[] nums) {
        if (nums.length > 0) { // corner case
            sum = new int[nums.length]; // initialize
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        
        if (i > 0) { // corner case
            return sum[j] - sum[i - 1];
        } else {
            return sum[j];
        }
    
}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */