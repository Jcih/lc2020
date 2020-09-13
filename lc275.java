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
        return len - left;// need to think why, because h_index need to calculate by number greater than mid
    }
}

//
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        
        int left = 0;
        int right = citations.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (citations[mid] >= citations.length - mid) {
                right = mid - 1;
                res = Math.max(res, citations.length - mid);
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}