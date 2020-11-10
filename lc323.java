//DFS
class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }

        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfs(map, visited, i);
                count++;
            }
        }
        return count;       
    }
    
    public void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int i) {
        for (int j : map.get(i)) {
            if (visited.add(j)) {
                dfs(map, visited, j);
            }
        }
        
    }
}


//DFS 2nd way to store visited nodes
class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        int[] visited = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(map, visited, i);
                count++;
            }
        }
        return count;   
    }
    
    public void dfs(Map<Integer, List<Integer>> map, int[] visited, int i) {
        for (int j : map.get(i)) {
            if (visited[j] == 0) {
                visited[j] = 1;
                dfs(map, visited, j);
            }
        }
        
    }
}


//Union Find
class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) return n;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        for (int[] edge : edges) {
            int x = find(roots, edge[0]);
            int y = find(roots, edge[1]);
            if (x != y) {
                roots[x] = y;
                n--;
            }
        }
        return n;
    }
    public int find(int[] roots, int id) {
        int x = id;
        while (roots[id] != id) {
            id = roots[id];
        }
        while (roots[x] != id) {
            int fa = roots[x];
            roots[x] = id;
            x = fa;
        }
        return id;
    }
    
    
}


//Union Find
class Solution {
    public int countComponents(int n, int[][] edges) {
    int[] roots = new int[n];
    for(int i = 0; i < n; i++) roots[i] = i; 

    for(int[] e : edges) {
        int root1 = find(roots, e[0]);
        int root2 = find(roots, e[1]);
        if(root1 != root2) {      
            roots[root1] = root2;  // union
            n--;
        }
    }
    return n;
}

public int find(int[] roots, int id) {
    while(roots[id] != id) {
        roots[id] = roots[roots[id]];  // optional: path compression
        id = roots[id];
    }
    return id;
}
    
    
}