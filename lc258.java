
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