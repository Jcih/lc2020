class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();
        
        while (i < j) {
            if(vowels.indexOf(array[i]) != -1) {
                
                if (vowels.indexOf(array[j]) != -1) {
                    char tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return new String(array);
    }
}