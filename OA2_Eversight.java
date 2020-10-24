/*
-- Eversight OA 2

Find the length of the  longest circle in an array:
A[0] = 5, A[1] =4, A[2]=0, A[3]=3,A[4] = 1,A[5] = 6, A[6] = 2 , 
the longest circle is {0, 5, 6, 2}, return 4.
*/


class Solution {
	public int maxLength(int[] A) {
		int res = 0;
		if (A == null || A.length == 0) return res;

		HashSet<Integer> visitedIdx = new HashSet<>();

		for (int i = 0; i < A.length; i++) {
			int cur = A[i];
			if (visitedIdx.contains(A[i])) {
				int count = 1;
				while (visitedIdx.contains(A[cur]) && cur != i) {
					count++;
					cur = A[cur];
				}
				res = Math.max(res, count);
			} 
			visitedIdx.add(i);
		}
		return res;
	}
}