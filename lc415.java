class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(n, m); i++) {
            int c1 = n - 1 - i >= 0 ? num1.charAt(n - 1 - i) - '0' : 0;
            int c2 = m - 1 - i >= 0 ? num2.charAt(m - 1 - i) - '0' : 0;
            int c = c1 + c2 + carry;
            if (c >= 10) {
                c -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans.append(c);
        }
        if (carry != 0) { ans.append(carry); }
        return ans.reverse().toString();
    }
}


//Solution II
//facebook
//https://www.youtube.com/watch?v=_Qp-CTzat50
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }
            
            res.append(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}