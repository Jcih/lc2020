//不会， 不懂
、、https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/532560/JavaC%2B%2BPython-DFS
class Solution{
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        int total = 0;
        for (int i = 0; i < manager.length; i++) {
        	int j = manager[i];
        	if (!graph.containsKey(j)) {
        		graph.put(j, new ArrayList<>());

        	}
        	graph.get(j).add(i);
        }
        return dfs(graph, informTime, headID);
    }
    private int dfs(final Map<Integer, List<Integer>> graph, final int[] informTime, final int cur) {
    	int max = 0;
    	if (!graph.containsKey(cur)) {
    		return max;
    	}
    	for (int i = 0; i < graph.get(cur).size(); i++) {
    		max = Math.max(max, dfs(graph, informTime, graph.get(cur).get(i)));
    	}
    	return max + informTime[cur];
    }
}