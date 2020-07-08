//https://leetcode.com/problems/set-matrix-zeroes/discuss/26008/My-AC-java-O(1)-solution-(easy-to-read)
class Solution {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstRow = false, firstCol = false;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) firstRow = true;
					if (j == 0) firstCol = true;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0|| matrix[0][j] == 0) {
					matrix[i][j] == 0;
				}
			}
		}

		if (firstRow) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}

		}
		if (firstCol) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;

			}
		}

	}
}