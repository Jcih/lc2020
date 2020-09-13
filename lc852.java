//FACEBOOK
// Solution I O(N)
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}



//Solution II
class Solution {
	public int peakIndexInMountainArray(int[] A) {
		int i = 0;
		while (A[i] < A[i + 1]) {
			i++;
		}
		return i;
	}
}


//Solution III binary Search O(logN)
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    
    }
}