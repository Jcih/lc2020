class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> from_to = new HashMap<>();
        
        for (List<String> list : paths) {
            from_to.put(list.get(0), list.get(1));
        }
        
        for (Map.Entry<String, String> entry : from_to.entrySet()) {
            String to = entry.getValue();
            if (!from_to.keySet().contains(to)) {
                return to;
            }
        }
        
        return "";
    }
}