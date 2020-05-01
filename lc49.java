//https://www.youtube.com/watch?v=ptgykfAEax8
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        if (strs.length == 0 || strs == null)
            return res;
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] singleWord = strs[i].toCharArray();
            Arrays.sort(singleWord);
            
            String sortedStr = new String(singleWord);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map.put(sortedStr, tmp);
            }
        }

        //add all map values to list.
        
        //solution I
        /*
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        */
        //Solution II
        res.addAll(map.values());
        
        return res;
    }
}