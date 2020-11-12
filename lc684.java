//684 UNION FIND
class Solution {
    
    int[] res = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        Arrays.fill(parent, -1);
        
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            
            union(parent, i , j, rank);
        }
        return res;
    }
    
    public int find(int[] parent, int i) {
        int i_root = i;
        while (parent[i_root - 1] != -1) {
            i_root = parent[i_root - 1]; 
        }
        return i_root;
    }
    
    public void union(int[] parent, int i, int j, int[] rank) {
        int i_root = find(parent, i);
        int j_root = find(parent, j);
 
        if (i_root == j_root) {
            res[0] = i;
            res[1] = j;
            
        } else {
            // Make root of smaller rank point to root of larger rank.
            if (rank[i_root- 1] > rank[j_root - 1]) {
                parent[j_root - 1] = i_root;
            } else if (rank[i_root - 1] < rank[j_root - 1]) {
                parent[i_root - 1] = j_root;
            } else {
                parent[i_root - 1] = j_root;
                rank[j_root - 1]++;
            }
        }
        
    }
}