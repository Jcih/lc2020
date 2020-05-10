//google 
//https://www.youtube.com/watch?v=evesA3gr9BE

class Solution {
	public int shortestWay(String source, String target) {
		int numSequences = 0;
		String remaining = target;
		while (remaining.length() > 0) {
			StringBuilder subsequence = new StringBuilder();

			int i = 0, j = 0;
			while (i < source.length() && j < remaining.length()) {
				if (source.charAt(i++) == remaining.charAt(j) {
					subsequence.append(remaining.charAt(j++));
				}
			}

			if (subsequence.length() == 0) {
				return -1;
			}
			numSequences++;
			remaining = remaining.substring(subsequence.length());
		}
		return numSequences;
	}
}