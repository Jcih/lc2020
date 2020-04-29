import java.math.*;

// backtrack
//similar questions
//http://www.noteanddata.com/leetcode-46-Permutations-java-solution-note.html
//http://www.noteanddata.com/leetcode-93-Restore-IP-Addresses-java-solution-note.html
//http://www.noteanddata.com/leetcode-131-Palindrome-Partitioning-java-solution-note.html
class Solution {
    public boolean isAdditiveNumber(String num) {
        return helper(num, new ArrayList<BigInteger>());
    }
    
    public boolean helper(String remain, ArrayList<BigInteger> cur) {
        if(remain.length() == 0) {
            return cur.size() >= 3;
        }
        if(cur.size() < 2) {
            for (int i = 0; i < remain.length(); ++i) {
                String part = remain.substring(0, i + 1);
                if(part.length() > 1 && part.startsWith("0")) {
                    continue;
                }
                cur.add(new BigInteger(part));
                if(helper(remain.substring(i+1), cur)) {
                    return true;
                }
                cur.remove(cur.size() - 1);
            }
        }
        else {
            BigInteger nextval = cur.get(cur.size() - 1).add(cur.get(cur.size() - 2));
            String next = String.valueOf(nextval);
            if(remain.startsWith(next)) {
                cur.add(nextval);
                if(helper(remain.substring(next.length()), cur)) {
                    return true;
                }
                cur.remove(cur.size() - 1);
            }
        }
        return false;
    }
}