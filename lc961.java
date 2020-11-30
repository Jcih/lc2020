class Solution {
    public int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) return -1;
        
        int N = A.length / 2;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : A) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            if (freq.get(i) == N)
                return i;
        }
        return -1;
    }
}