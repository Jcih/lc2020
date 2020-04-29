class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        
        ArrayDeque<String> q = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                q.pollLast();
            } else if (s.equals(".") || s.equals("")) {
                continue;
            } else {
                q.add(s);
            }
        }
        
        for (String s : q) {
            sb.append(s + "/");
        }
        
        if (q.size() != 0) {
            //StringBuilder.setLength  can be used to remove the last character
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
        
    }
}