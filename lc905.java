class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        
        int[] res = new int[A.length];
        
        int idx = 0;
        Queue<Integer> odd = new LinkedList<>();
        for (int i : A) {
            if (i % 2 == 0) {
                res[idx++] = i;
            } else {
                odd.offer(i);
            }
        }
        while (!odd.isEmpty()) {
            res[idx++] = odd.poll();
        }
        return res;
         
    }
}