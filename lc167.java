//20200903
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;  
        int lo = 0;
        int hi = numbers.length - 1;
        int[] res = new int[2];
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] > target) {
                hi--;
            } else if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                res[0] = lo + 1;
                res[1] = hi + 1;
                break;
            }
        }
        return res;
    }
}


//
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