class Solution {
    
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaining = 0;
        int total = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int remaining = gas[i] - cost[i];
            
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }
        if (total >= 0)
            return start;
        else 
            return -1;
    }
}

//https://leetcode.com/problems/gas-station/discuss/167542/10-lines-Python-that-beats-100-NO-PROOF-IN-HERE
//https://leetcode.com/problems/gas-station/discuss/42667/Straightforward-Java-Linear-Solution-with-O(1)-space-explanation-and-Math-proof
class Solution {   
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i]- cost[i];
        }
        //toal gas is less than toal cost, impossible
        if (total < 0) {
            return -1;
        }
        
        int start = 0;//start point
        int left = 0;//gas left from the previous travel
        for (int i = 0; i < gas.length; i++) {
            int cur = gas[i] - cost[i];
            if (left + cur < 0) {// could not arrive the next point
                start = i + 1;// why not start++?   index i is not qualified, at least should start from i + 1;
                left = 0;
            } else {
                left += cur;
            }
        }
        return start;
    }
}