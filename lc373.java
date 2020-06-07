
//credit : http://www.noteanddata.com/leetcode-373-Find-K-Pairs-with-Smallest-Sums-weride-interview-problem-java-solution-note.html
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] + b[1] - a[0] - a[1];
            }
        });
        
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                pq.add(new int[] {nums1[i], nums2[j]});
                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }
        
        LinkedList<List<Integer>> all = new LinkedList<>();
        while (pq.size() > 0) {
            int[] item = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(item[0]);
            list.add(item[1]);
            all.addFirst(list);
        }
        return all;
    }
    }


    // 20200530
    class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);// maxHeap, from large to small sort.
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.offer(new int[] {nums1[i], nums2[j]});
                if (pq.size() > k) {
                    // keep k smallest objects
                    pq.poll();
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        while (pq.size() > 0) {
            List<Integer> cur = new ArrayList<>();
            int[] item = pq.poll();
            cur.add(item[0]);
            cur.add(item[1]);
            res.add(0, cur);
        }
        return res;
    }
}