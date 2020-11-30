class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) return res;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String cp : cpdomains) {
            String[] s = cp.split(" ");
            int count = Integer.valueOf(s[0]);
            String domain = s[1];
            
            List<String> domains = new ArrayList<>();
            domains.add(domain);
            int idx = -1;
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    idx = i;
                    domains.add(domain.substring(i + 1));
                }
            }
            for (String item : domains) {
                 map.put(item, map.getOrDefault(item, 0) + count);
            }
   
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String cur = entry.getValue() + " " + entry.getKey();
            res.add(cur);
        }
        return res;
        
        
    }
}