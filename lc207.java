//https://zxi.mytechroad.com/blog/graph/leetcode-207-course-schedule/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
            
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prere = prerequisites[i][1];
            graph.get(course).add(prere);
        }
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) return false;
        }
        return true;
    }
    
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) return true;
        if (visited[curr] == 2) return false;
        visited[curr] = 1;
        
        for (int next: graph.get(curr)) {
            if (dfs(next, graph, visited)) return true;
        }
        visited[curr] = 2;
        return false;
    }
}


//Solution II 
//https://leetcode.com/problems/course-schedule/discuss/58524/Java-DFS-and-BFS-solution
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int course1 = pre[0];
            int course2 = pre[1];
            map.get(course1).add(course2);
            
        }
        
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, map, visited))
                return false;
        }
        return true;
    }
    
    private boolean dfs(int cur, Map<Integer, List<Integer>> map, int[] visited) {
        if (visited[cur] == 1) return true;
        if (visited[cur] == 2) return false;
        visited[cur] = 1;
        
        for (int i = 0; i < map.get(cur).size(); i++) {
            if (dfs(map.get(cur).get(i), map, visited))
                return true;
        }
        visited[cur] = 2;
        return false;
    }
}