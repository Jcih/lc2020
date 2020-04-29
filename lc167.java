class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;
        
        int i = 0, j = numbers.length - 1;
        
        while ( i < j) {
            int tmp = numbers[i] + numbers[j];
            
            if (tmp < target)
                i++;
            else if (tmp > target)
                j--;
            else 
                return new int[] {i + 1, j + 1};
        }
        return null;
    }
}