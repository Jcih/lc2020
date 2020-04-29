//https://www.youtube.com/watch?v=0y7pU6PPrc4   

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        
        if (s == null || s.length() <= 10)
            return res;
        
        HashMap<String, Integer> subSeq = new HashMap<>();
        
        int i = 0;
        while ( i + 10 <= s.length()) {
            String substr = s.substring(i, i + 10);
            i++;
            subSeq.put(substr, subSeq.getOrDefault(substr, 0) + 1);
            if (subSeq.get(substr) == 2)
                res.add(substr);
        }
        return res;
    }
}