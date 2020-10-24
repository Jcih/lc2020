class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int idx = 0;
        for (int i : arr1) {
            count[i]++;
        }
        
        int i = 0;
        for (int n : arr2) {
            while (count[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        
        for (int n = 0; n < count.length; n++) {
            while (count[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        
        return arr1;
    }
}


//Solution II
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int idx = 0;
        for (int n : arr2) {
            for (int j = 0; j < map.get(n); j++) {
                arr1[idx++] = n;
            }
            map.remove(n);
        }
        
        for (int i : map.keySet()) {
            for (int j = 0; j < map.get(i); j++) {
                arr1[idx++] = i;
            }
        }
        return arr1;
    }
}