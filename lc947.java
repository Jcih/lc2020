//947   DFS   == number of island 
class Solution {
    public int removeStones(int[][] stones) {
         
        int count = 0;
        Set<int[]> visited = new HashSet<>();
        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                dfs(stone, visited, stones);
                count++;
            }
        }
        return stones.length - count;
    }
    
    public void dfs(int[] s1, Set<int[]> visited, int[][] stones) {
        visited.add(s1);
        
        for (int[] s2 : stones) {
            if (!visited.contains(s2)) {
                if (s2[0] == s1[0] || s2[1] == s1[1]) {
                    dfs(s2, visited, stones);
                }
            }
        }
    }
    
    
}






//Union - Find I
class Solution {
    
    int count = 0;
    public int removeStones(int[][] stones) {
        
        HashMap<String, String> parent = new HashMap<>();
        count = stones.length;
        for (int[] stone : stones) {
            String s = stone[0] + " " + stone[1];
            
            parent.put(s, s);
        }       
        
        for (int[] s1 : stones) {
            String ss1 = s1[0] + " " + s1[1];
            for (int[] s2 : stones) {
                if (s1[0] == s2[0] || s1[1] == s2[1]) {
                    String ss2 = s2[0] + " " + s2[1];
                    union(parent, ss1, ss2);
                }
            }
            
        }
        
        return stones.length - count;
    }
    
    public void union(HashMap<String, String> parent, String ss1, String ss2) {
        String root1 = find(parent, ss1);
        String root2 = find(parent, ss2);
        
        if (!root1.equals(root2)) {
            parent.put(root1, root2);
            count--;
        }  
    }
    
    public String find(HashMap<String, String> parent, String s) {
        
        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent, parent.get(s)));
        }
        return parent.get(s);
    }   
}



//Union Find II
class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    int island = 0;
    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; i++) {
            union(stones[i][0], ~stones[i][1]);
        }
        return stones.length - island;
    }
    
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if (px != py) {
            map.put(px, py);
            island--;
        }
    }
    
    public int find(int x) {
        if (map.putIfAbsent(x, x) == null) {
            island++;
        }
        
        if (map.get(x) != x) {
            map.put(x, find(map.get(x)));
        }
        return map.get(x);
    }
}