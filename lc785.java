//https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E5%9B%BE.md#1-%E5%88%A4%E6%96%AD%E6%98%AF%E5%90%A6%E4%B8%BA%E4%BA%8C%E5%88%86%E5%9B%BE
//https://www.youtube.com/watch?v=FofydiwP5YQ
//https://www.youtube.com/results?search_query=is+graph+bipartite+leetcode
//https://www.youtube.com/watch?v=Gmp51E8HVVs

class Solution {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] colors = new int[nodes];
        Arrays.fill(colors, -1);// mark all unvisited nodes as -1
        
        for (int i = 0;i < nodes; i++) {
            if (colors[i] == -1 && !dfs(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (!dfs(nextNode, 1 - curColor, colors, graph)) {
                return false;
            }
        }
        return true;
    }
}