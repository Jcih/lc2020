class Solution {
    public String tictactoe(int[][] moves) {
        String res = "";
        if (moves == null || moves.length == 0) {
            res = "Pending";
        }
        
        int[][] map = new int[3][3];
        boolean turnA = true;
        
        for (int[] coor : moves) {
            if (turnA)
                map[coor[0]][coor[1]] = 1;
            else 
                map[coor[0]][coor[1]] = 2;
            turnA = !turnA;   
        }
        
        boolean[][] visited = new boolean[3][3];
        int flag = 0;
        
        a: 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    flag = dfs(map, i , j, visited);
                    if (flag == 1 || flag == 2)
                        break a;
                }
            }
        }
        
        if (flag == 0) {
            if (moves.length < 9) {
                res = "Pending";
            } else {
                res = "Draw";
            }
        } else if (flag == 1) {
            res = "A";
        } else if (flag == 2) {
            res = "B";
        }
        
        return res;
        
    }
    
    
    public int dfs(int[][] map, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        
        int group = map[i][j];
        
        for (int k = 0; k < 3; k++) {
            if (map[k][j] != group) break;
            if (k == 2) {
                return group;
            }
        }
        
        for (int k = 0; k < 3; k++) {
            if (map[i][k] != group) break;  
            if (k == 2) return group;
        }
        
        //check diagnol
        if (i == 1 && j == 1) {
            if (map[0][0] == group && map[2][2] == group || map[2][0] == group && map[0][2] == group) {
                return group;
            }
        }
        
        return 0;
  
    }
}