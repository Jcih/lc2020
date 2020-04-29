//https://www.programcreek.com/2014/05/leetcode-h-index-java/
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int res = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int count = citations.length - i;
            if (citations[i] >= count)
                res = count;
            else 
                break;
        }
        return res;
    }
}