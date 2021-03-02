class Solution {
    public int findCircleNum(int[][] isConnected) {
        //union find
        //it's different from the number of island, which is only four directions connection
        //this case need to group n - 1 nodes, union find is a good solution to group them.
        int[] parent = new int[isConnected.length];
        Arrays.fill(parent, -1);
        
        int res = 0;
        if (isConnected == null || isConnected.length == 0) return res;
        int row = isConnected.length, col = isConnected[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        
        for (int i : parent) {
            if (i == -1) res++;
        }
        return res;
    }
    
    public void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[py] = px;
        }
    }
    
    public int find(int[] parent, int x) {
        int px = x;
        while (parent[px] != -1) {
            px = parent[px];
        }
        return px;
    }
}



//rank version , faster
class Solution {
    public int findCircleNum(int[][] isConnected) {
        //union find
        //it's different from the number of island, which is only four directions connection
        //this case need to group n - 1 nodes, union find is a good solution to group them.
        int[] parent = new int[isConnected.length];
        int[] rank = new int[isConnected.length];
        Arrays.fill(parent, -1);
        
        int res = 0;
        if (isConnected == null || isConnected.length == 0) return res;
        int row = isConnected.length, col = isConnected[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(parent, i, j, rank);
                }
            }
        }
        
        for (int i : parent) {
            if (i == -1) res++;
        }
        return res;
    }
    
    public void union(int[] parent, int x, int y, int[] rank) {
        int px = find(parent, x);
        int py = find(parent, y);
        
        if (px != py) {
            if (rank[px] > rank[py]) {
            parent[py] = px;
       
            } else if (rank[px] < rank[py]) {
                parent[px] = py;

            } else {
                parent[px] = py;
                rank[py]++;
            }
        }
        
        

    }
    
    public int find(int[] parent, int x) {
        int px = x;
        while (parent[px] != -1) {
            px = parent[px];
        }
        return px;
    }
}


//DFS
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}