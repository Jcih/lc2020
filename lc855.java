//https://leetcode.com/problems/exam-room/discuss/139862/C%2B%2BJavaPython-Straight-Forward
//FACEBOOK
class ExamRoom {
    int n;
    ArrayList<Integer> L = new ArrayList<>();
    

    public ExamRoom(int N) {
        n = N;    
    }
    
    public int seat() {
        if (L.size() == 0) {
            L.add(0);
            return 0;
        }
        int d = Math.max(L.get(0), n - 1 - L.get(L.size() - 1));
        for (int i = 0; i < L.size() - 1; i++) {
            d = Math.max(d, (L.get(i + 1) - L.get(i)) / 2);
        }
        if (L.get(0) == d) {
            L.add(0, 0);
            return 0;
        }
        for (int i = 0; i < L.size() - 1; i++) {
            if ((L.get(i + 1) - L.get(i)) / 2 == d) {
                L.add(i + 1, (L.get(i + 1) + L.get(i)) / 2);
                return L.get(i + 1);
            }
        }
        L.add(n - 1);
        return n - 1;
    }
    
    public void leave(int p) {
        for (int i = 0; i < L.size(); i++) {
            if (L.get(i) == p)
                L.remove(i);
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */