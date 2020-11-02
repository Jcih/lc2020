//there is one wrong test cases

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];
        
        int z1 = rec2[0];
        int w1 = rec2[1];
        int z2 = rec2[2];
        int w2 = rec2[3];
        
        if (x1 >= z2 || x2 <= z1 || y1 >= w2 || y2 <= w1) return false;

        //take care of a line, not rectangular
        if (x1 == x2 || y1 == y2 || z1 == z2 || w1 == w2) return false;
        return true;
        
    }
}