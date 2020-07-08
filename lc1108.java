//Apple, FACEBOOK
//https://www.youtube.com/watch?v=bJTgBNT3LbA

//Solution I
class Solution {
    public String defangIPaddr(String address) {
        
        if (address == null || address.length() == 0) {
            return address;
        } 
        
        return address.replaceAll("\\.", "\\[\\.\\]");
    }
}

//Solution II
class Solution {
    public String defangIPaddr(String address) {
        
        if (address == null || address.length() == 0) {
            return address;
        } 
        
        //return address.replaceAll("\\.", "\\[\\.\\]");
        
        String[] ip = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        
        for (String s: ip) {
            sb.append(s + "[.]");
        }
        
        return sb.toString().substring(0, sb.length() - 3);
    }
}


//Solution III
class Solution {
    public String defangIPaddr(String address) {
        
        if (address == null || address.length() == 0) {
            return address;
        } 
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
}