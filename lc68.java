//https://www.youtube.com/watch?v=GqXlEbFVTXY
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        int i = 0, n = words.length;
        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();
            while (j < n && (lineLength + words[j].length() + (j - i - 1) < maxWidth)) {
                lineLength += words[j].length();
                ++j;
            }
            
            int diff = maxWidth - lineLength;
            int numberOfWords = j - i;
            if (numberOfWords == 1 || j >= n) {
                //left justification
                result.add(leftJustify(words, diff, i, j));
            } else {
                //middle justification
                result.add(middleJustify(words, diff, i, j));
            }
            i = j;
        }
        return result;
        
    }
    
    private String middleJustify(String[] words, int diff, int i, int j) {
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraSpaces = diff % spacesNeeded;
        
        StringBuilder res = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            res.append(" ".repeat(spacesToApply) + words[k]);
        }
        return res.toString();
    }
    
    
    
    
    private String leftJustify(String[] words, int diff, int i, int j) {
        int spacesOnRight = diff - (j - i - 1);
        StringBuilder res = new StringBuilder(words[i]);
        
        for (int k = i + 1; k < j; k++) {
            res.append(" " + words[k]);
        }
        res.append(" ".repeat(spacesOnRight));
        return res.toString();
    }
}