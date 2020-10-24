class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        String croak = "croak";
        int[] dict = new int[5];
        int res = 0;
        int cur = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            int index = croak.indexOf(c);
            if (index < 0) return -1;
            
            dict[index]++;
            
            if (c == 'c') {
                cur++;
            }
            if (c == 'k') {
                cur--;
            }
            
            res = Math.max(res, cur);
            if (dict[0] < dict[1] ||
               dict[1] < dict[2] ||
               dict[2] < dict[3] ||
               dict[3] < dict[4])
                return -1;
            
        }
        
        if (cur == 0 && dict[0] == dict[1] && dict[1] == dict[2] && dict[2] == dict[3] && dict[3] == dict[4]) return res;
        return -1;
    }
}