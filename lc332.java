
//dfs
//http://www.noteanddata.com/leetcode-332-Reconstruct-Itinerary-java-solution-note.html
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            List<String> list = map.get(from);
            if (list == null) {
                list = new ArrayList<>();
                map.put(from, list);
            }
            list.add(to);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        
        List<String> list = new ArrayList<>();
        list.add("JFK");
        dfs(map, list, tickets.size() + 1);
        return list;
        
    }
    
    public boolean dfs(Map<String, List<String>> tickets, List<String> ret, int expectLen) {
        if (ret.size() == expectLen) {
            return true;
        }
        List<String> dest = tickets.get(ret.get(ret.size() - 1));
        if (dest == null) {
            return false;
        }
        for (int i = 0; i < dest.size(); i++) {
            ret.add(dest.get(i));
            dest.remove(i);
            if (dfs(tickets, ret, expectLen)) {
                return true;
            }
            dest.add(i, ret.get(ret.size() - 1));
            ret.remove(ret.size() - 1);
            
        }
     return false;   
    }
    
}