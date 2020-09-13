
//done 2 times
class Solution {
    public int addDigits(int num) {
        int sum = num;
         while (num > 9) {
             sum = 0;
             while (num > 9) {
                 sum += num % 10;
                 num /= 10;
             }
             sum += num;
             num = sum;;
         }
        return sum;
    }
}


//Solutino II, same solution with I
class Solution {
    public int addDigits(int num) {
        int sum;
        
        while (num > 9) {
            sum = 0;
            while (num > 9) {
                sum += num % 10;
                num /= 10;
            }
            sum += num;
            num = sum;
        }
    
        return num;
    }
        
}


//disgusting math solution 
class Solution {
    public int addDigits(int num) {
        
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}