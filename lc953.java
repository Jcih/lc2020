//20200709 第二遍， 能理解， 希望下一遍能自己想出来
//https://www.youtube.com/watch?v=jZBnFxIe4Y8
//facebook
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), count++);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int min = Math.min(words[i].length(), words[j].length());
                for (int k = 0; k < min; k++) {
                    char i_char = words[i].charAt(k);
                    char j_char = words[j].charAt(k);
                    if (map.get(i_char) < map.get(j_char)) {
                        break;
                    } else if (map.get(i_char) > map.get(j_char)) {
                        return false;
                    } else if (k == min - 1 && words[i].length() > words[j].length()) {
                        return false;
                    }
                }
                                  
            }
        }
        
        return true;
    }
}