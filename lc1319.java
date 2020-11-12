//1319 Union Find

class Solution {  
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        
        for (int[] connect : connections) {
            union(parent, connect[0], connect[1]);
        }
        
        int count = 0;
        for (int i : parent) {
            if (i == -1) {
                count++;
            }
        }
        return count - 1;
    }   
    
    public void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        
        if (px != py) {
            parent[px] = py;
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


//1319 Union Find with Rank , much faster
class Solution {  
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(parent, -1);
        
        for (int[] connect : connections) {
            union(parent, connect[0], connect[1], rank);
        }
        
        int count = 0;
        for (int i : parent) {
            if (i == -1) {
                count++;
            }
        }
        return count - 1;
    }   
    
    public void union(int[] parent, int x, int y, int[] rank) {
        int px = find(parent, x);
        int py = find(parent, y);
        
        if (px != py) {
            if (rank[px] < rank[py]) {
                arent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
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