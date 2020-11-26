class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if (image == null || image.length == 0) return image;
        int color = image[sr][sc];
        if (color != newColor)
            dfs(image, sr, sc, newColor, color);
        
        return image;
    }
    public void dfs(int[][] image, int i, int j, int newColor, int color) {
        if (i < 0 || i > image.length - 1 || j < 0 || j > image[0].length - 1 || image[i][j] != color) {
            return;
        }
        if (image[i][j] == color) 
            image[i][j] = newColor;
        dfs(image, i + 1, j, newColor, color);
        dfs(image, i - 1, j, newColor, color);
        dfs(image, i, j + 1, newColor, color);
        dfs(image, i, j - 1, newColor, color);
    }
}