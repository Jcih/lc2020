class Solution {
    public int hIndex(int[] citations) {
        int res = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int cnt = citations.length - i;
            if (citations[i] >= cnt) {
                res = cnt;
            } else {
                break;
            }
        }
        return res;
    }
}



//Using binary search to get O(logn)
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        
        int left = 0, right = len - 1;
        
        while (left <= right) { // caution: <= not <
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid)
                return len - mid;
            else if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return len - left;// need to think why
    }
}