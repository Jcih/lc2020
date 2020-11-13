//Union Find
class Solution {
    
    
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        Arrays.fill(parent, -1);
        
        for (String s : equations) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            
            char flag = s.charAt(1);
            if (flag == '=')
                union(parent, x, y, flag);
        }
        
        for (String s1 : equations) {
            if (s1.charAt(1) == '!' && find(parent, s1.charAt(0) - 'a') == find(parent, s1.charAt(3) - 'a'))
                return false;
        }
        
        return true;
    }
    
    public void union(int[] parent, int x, int y, char flag) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py)
            parent[px] = py; 
    }
    
    public int find(int[] parent, int x) {
        int px = x;
        
        while (parent[px] != -1) {
            px = parent[px];
        }
        return px;
    }  
}