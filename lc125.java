//Solution I
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}


//Solution II
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;
        char[] arr = s.toCharArray();
        
        int left = 0;
        int right = arr.length - 1;
        
        while ( left < right) {
            while (left < right && !Character.isLetterOrDigit(arr[left]))
                left++;
            while (left < right && !Character.isLetterOrDigit(arr[right]))
                right--;
            if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right]))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}