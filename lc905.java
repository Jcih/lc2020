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

//In-place
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0; 
        int j = A.length - 1;
        
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }
        return A;
    }
}