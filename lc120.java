class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        int len = triangle.size() - 1;
        for (int i = 0; i < triangle.get(len).size(); i++){
            total[i] = triangle.get(len).get(i);
        }
        
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j+ 1]);
            }
        }
        
        return total[0];
    }
}