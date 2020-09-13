//题目看不懂
//20200709 第一遍
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
		for (int x = A.length; x > 0; x--) {
			int i = 0;
            while (A[i] != x) {
				i++;
			}
			reverse(A, i + 1);
			res.add(i + 1);
			reverse(A, x);
			res.add(x);
			

		}
		return res;
    }
    public void reverse(int[] A, int k) {
		for (int i = 0, j = k - 1; i < j; i++, j--) {
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
		}
	}
}