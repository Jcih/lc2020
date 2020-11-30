/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        if (schedule == null || schedule.size() == 0) return res;
        
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        
        for (List<Interval> list : schedule) {
            for (Interval i : list) {
                pq.offer(i);
            }
        }
        
        Interval cur = pq.poll();
        
        while (!pq.isEmpty()) {
            if (cur.end < pq.peek().start) {
                Interval tmp = new Interval();
                tmp.start = cur.end;
                tmp.end = pq.peek().start;
                res.add(tmp);
                cur = pq.poll();
            } else {
                if (cur.end < pq.peek().end) {
                    cur = pq.peek();
                } 
                pq.poll();
            }
        }
        return res;
    }
}