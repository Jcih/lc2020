//FACEBOOK
//20200712第一遍
class Solution {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }
        
        String[] words = S.split("\\s");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            Character firstLetter = words[i].charAt(0);
            
            if (vowels.contains(firstLetter)) {
                sb.append(" " + words[i] + "ma");
            } else {
                sb.append(" " + words[i].substring(1) + firstLetter + "ma");
            }
            
            int count = 0;
            while (count <= i) {
                sb.append("a");
                count++;
            }
            
        }
        
        sb.deleteCharAt(0);
        return sb.toString();
    }
}