// graph list
//https://leetcode.com/list?selectedList=5pbpwq1s
//https://leetcode.com/discuss/general-discussion/655708/graph-for-beginners-problems-pattern-sample-solutions/
//https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B


/*

Union Find:

Identify if problems talks about finding groups or components.

https://leetcode.com/problems/friend-circles/
https://leetcode.com/problems/redundant-connection/
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
https://leetcode.com/problems/number-of-operations-to-make-network-connected/
https://leetcode.com/problems/satisfiability-of-equality-equations/
https://leetcode.com/problems/accounts-merge/
*/

////////////////////////////////////////////////
//Union Find Template without rank[]:

int[] parent = new int[arr.length];
Arrays.fill(parent, -1);

public int find(int[] parent, int i) {
        int i_root = i;
        while (parent[i_root] != -1) {
            i_root = parent[i_root];
        }
        return i_root;
    }
    
public void union(int[] parent, int x, int y) {
    int x_root = find(parent, x);
    int y_root = find(parent, y);
    if (x_root != y_root) {
        parent[x_root] = y_root;
    }
}

////////////////////////////////////////////////


//Union Find Template with rank[]:

int[] parent = new int[arr.length];
int[] rank = new int[arr.length];
Arrays.fill(parent, -1);

public int find(int[] parent, int i) {
        int i_root = i;
        while (parent[i_root] != -1) {
            i_root = parent[i_root];
        }
        return i_root;
    }
    
public void union(int[] parent, int x, int y, int[] rank) {
    int x_root = find(parent, x);
    int y_root = find(parent, y);

    if (x_root != y_root) {
        if (rank[x_root] > rank[y_root]) {
        parent[y_root] = x_root;
        } else if (rank[x_root] < rank[y_root]) {
            parent[x_root] = y_root;
        } else {
            // ==
            parent[x_root] = y_root;
            rank[y_root]++;
        }
    }
    
}

////////////////////////////////////////////////

//547 UNION FIND
class Solution {
    public int findCircleNum(int[][] M) {
        
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
        
    }
    
    public int find(int[] parent, int i) {
        int i_root = i;
        while (parent[i_root] != -1) {
            i_root = parent[i_root];
        }
        return i_root;
    }
    
    public void union(int[] parent, int x, int y) {
        int x_root = find(parent, x);
        int y_root = find(parent, y);
        if (x_root != y_root) {
            parent[x_root] = y_root;
        }
    }
}





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




//947  DFS
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


//947 Union Find
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
                 parent[px] = py;
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




// 990 Union Find
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