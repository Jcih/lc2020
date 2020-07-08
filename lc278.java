//binary se@arch

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


// How about the terminating condition? 
//We could guess that left and right eventually both meet and it must be the first bad version, but how could you tell for sure?

// The formal way is to prove by induction, which you can read up yourself if you are interested. 
//Here is a helpful tip to quickly prove the correctness of your binary search algorithm during an interview. 
//We just need to test an input of size 2. Check if it reduces the search space to a single element (which must be the answer) for both of the scenarios above. 
//If not, your algorithm will never terminate.