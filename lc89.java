//https://www.programcreek.com/2014/05/leetcode-gray-code-java/
//Solution I
//https://leetcode.wang/leetCode-89-Gray-Code.html
class Solution {
    public List<Integer> grayCode(int n) {
        if(n==0){
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        return result;
        }
 
        List<Integer> result = grayCode(n-1);
        int numToAdd = 1<<(n-1);

        for(int i=result.size()-1; i>=0; i--){ //iterate from last to first
            result.add(numToAdd+result.get(i));
        }

        return result;
    }
}


//Solution II
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i<Math.pow(2,n); i++)
            l.add((i>>1)^i);
        return l;
    }
}