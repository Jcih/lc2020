//https://medium.com/competitive-programming/leetcode-401-binary-watch-e65f005a52e3
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }
}