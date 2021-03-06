class Solution {
    public int myAtoi(String str) {
        
        // remove whitespaces
        str = str.trim();
        
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        double result = 0;
        
        // handle positive and negative sign
        boolean isNegative = false;
        int startIndex = 0; // index of first numerical character
        
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            startIndex++;
        }
        if (str.charAt(0) == '-') {
            isNegative = true;
        }
        
        // handle normal case "123"
        for (int i = startIndex; i < str.length(); i++) {
            // handle non-numerical character
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            int digitValue = (int)(str.charAt(i) - '0'); // '9' - '0'   couldn't do Integer.valueOf(str.charAt(i)), check java character to int
            result = result * 10 + digitValue;
        }
        
        if (isNegative) {
            result = -result;
        }
        
        // handle out of Integer range
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)result;
        
    }


    //https://www.geeksforgeeks.org/convert-char-to-int-in-java-with-examples/
}