//20200922
class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0) {
            int sum = carry;
            if (m >= 0) {
                sum += a.charAt(m) - '0';
                m--;
            }
            if (n >= 0) {
                sum += b.charAt(n) - '0';
                n--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
            
        }
        if (carry != 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
        
    }
}


//https://www.youtube.com/watch?v=tRpusgdZxrE
class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        
        
        int carry = 0;
        int sum = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while (m >= 0 || n >= 0) {
            sum = carry;
            if (m >= 0) {
                sum += a.charAt(m) - '0';
                m--;
            }
            
            if (n >= 0) {
                sum += b.charAt(n) - '0';
                n--;
            }
            
            sb.insert(0, sum % 2);
            
            carry = sum / 2;
        }
        
        if (carry > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}