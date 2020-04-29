
// backtracking ip address
//similat with #46, #131
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        
        helper(res, new ArrayList<String>(), s);
        return res;
    }
    
    public void helper(List<String> res, List<String> cur, String s) {
        if (cur.size() == 4) {
            if (s.length() == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; ++i) {
                    sb.append(cur.get(i));
                    if (i < 3) sb.append(".");
                }
                res.add(sb.substring(0, sb.length()).toString());
            }
            return;
        }
        for (int i = 1; i <= 3 && i <= s.length(); ++i) {
            String part = s.substring(0, i);
            if (part.length() > 1 && part.startsWith("0")) continue;
            int v = Integer.valueOf(part);
            if (v < 0 || v > 255) continue;
            cur.add(part);
            helper(res, cur, s.substring(i));
            cur.remove(cur.size() - 1);
        }
    }
}