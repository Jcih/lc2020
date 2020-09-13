class Solution {
    public int[] sortedSquares(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b));
        for (int i : A) {
            pq.offer(i * i);
            
        }
        
        int[] res = new int[A.length];
        for (int j = 0; j < A.length; j++) {
            res[j] = pq.poll();
        }
        return res;
    }
}

//Solution II two pointers
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}



//
class Solution {
    public int[] sortedSquares(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);// lambda will overflow for long Integer. need to use Integer.compare(a, b)
        for (int i : A) {
            pq.offer(i * i);
            
        }
        
        int[] res = new int[A.length];
        for (int j = 0; j < A.length; j++) {
            res[j] = pq.poll();
        }
        return res;
    }
}