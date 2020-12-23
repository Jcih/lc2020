class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        
//         String newstr = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        
//         String[] tokens = paragraph.split("\\s+");
        
//         Set<String> banset = new HashSet<>();
        
//         for (String word : banned) {
//             banset.add(word);
//         }
        
//         HashMap<String, Integer> map = new HashMap<>();
//         for (String w : tokens) {
//             if (!banset.contains(w)) {
//                 map.put(w, map.getOrDefault(w, 0) + 1);
//             }
//         }
        
//         String res = "";
//         int max = 0;
        
//         for (Map.Entry<String,Integer> entry : map.entrySet()) {
//             if (entry.getValue() > max) {
//                 max = entry.getValue();
//                 res = entry.getKey();
//             }
//         }
//         return res;
        

    
        // split paragraph 
        String[] words = paragraph.toLowerCase().split("\\W+");
        
        // add banned words to set
        Set<String> set = new HashSet<>();
        for(String word : banned){
            set.add(word);
        }
        
        // add paragraph words to hash map
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(!set.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
            
        // get the most frequent word
        int max = 0; // max frequency
        String res = "";
        for(String str : map.keySet()){
            if(map.get(str) > max){
                max = map.get(str);
                res = str;
            }
        }
        
        return res;
    }
}
        
        
