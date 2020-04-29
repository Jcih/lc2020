class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C <= E || A >=G || B >= H || D <= F) {
            return (C - A) * (D - B) + (G - E)* (H - F);
        } else {
            int h1 = Math.min(G, C) - Math.max(A, E);
            int h2 = Math.min(D, H) - Math.max(B, F);
            
            return (C - A) * (D - B) + (G - E)* (H - F) - h1 * h2;
        }
    }
}