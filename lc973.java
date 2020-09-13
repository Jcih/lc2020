//https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] s : points) {
            minHeap.offer(s);
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }
        
        int[][] res = new int[K][2];
        while (K > 0) {
            res[K - 1] = minHeap.poll();
            K--;
        }
        return res;
        
    }
}


//Solution II
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a1, a2) -> a1[0] * a1[0] + a1[1] * a1[1] - a2[0] * a2[0] - a2[1] * a2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }
}