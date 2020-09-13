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


//20200725 two pointers
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return s;
        char[] arr = s.toCharArray();
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            
            while (i < j && !vowels.contains(arr[i])) {
                i++;
            }
            while (i < j && !vowels.contains(arr[j])) {
                j--;
            }
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
        
    }
}