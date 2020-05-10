//Solution I
//Amazon
class Solution {
    
    int[] directions = new int[] {0, 1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        
      Queue<int[]> rottens = new LinkedList<>();
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == 2) {
            rottens.add(new int[] {i, j});
          }
        }
      }
      int times = 0;
      while (!rottens.isEmpty()) {
        int size = rottens.size();
        boolean counted = false;
        for (int k = 0; k < size; k++) {
          int[] rotten = rottens.poll();
          for (int i = 0; i < 4; i++) {
            int x = rotten[0] + directions[i];
            int y = rotten[1] + directions[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
              grid[x][y] = 2;
              if (!counted) {
                times++;
              }
              counted = true;
              rottens.add(new int[] {x, y});
            }
          }
        }
      }
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == 1) {
            return -1;
          }
        }
      }
      return times;
    
    }
}




//Soluition II
//https://www.youtube.com/watch?v=TzoDDOj60zE
class Solution {
    public int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh.add("" + i + j);
                } else if (grid[i][j] == 2) {
                    rotten.add("" + i + j);
                }
            }
        }
        
        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (fresh.size() > 0) {
            Set<String> infected = new HashSet<>();
            for (String s : rotten) {
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                for (int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if (fresh.contains("" + nextI + nextJ)) {
                        fresh.remove("" + nextI + nextJ);
                        infected.add("" + nextI + nextJ);
                    }
                }
            }
            
            if (infected.size() == 0) {
                return -1;
            }
            
            rotten = infected;
            minutes++;
        }
        return minutes;
    
    }
}