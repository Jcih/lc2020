class Solution {
    public String[] findWords(String[] words) {
        
        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";
        
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character c : row1.toCharArray()) {
            map.put(c, 1);
        }
        for (Character c : row2.toCharArray()) {
            map.put(c, 2);
        }
        for (Character c : row3.toCharArray()) {
            map.put(c, 3);
        }
        
         ArrayList<String> arrList = new ArrayList<>();
        for (String word : words) {
            
            
            boolean flag = true;
            
            int row = map.get(word.charAt(0));
            for (Character c  : word.toCharArray()) {
                if (map.get(c) != row ) {
                    flag = false;
                } 
                
            }
            
           
            if (flag) {
                arrList.add(word);
            }
        }
        String[]  res = new String[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            res[i] = arrList.get(i);
        }
        return res;
        
    }
}