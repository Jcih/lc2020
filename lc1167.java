//Amazon
// Time : O(nlogn) for PriorityQueue, Space: T(n)
class Solution {
	public int connectSticks(int[] sticks) {
		int cost = 0;
		PriotiryQueue<Integer> minHeap = new PriorityQueue<>();
		for (int stick : sticks) {
			minHeap.add(stick);
		}

		while (minHeap.size > 1) {
			int sum = minHeap.remove() + minHeap.remove();
			cost += sum;
			minHeap.add(sum);
		}

		return cost;
	}
}