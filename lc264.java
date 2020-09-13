//https://blog.csdn.net/zdavb/article/details/47948281
//https://www.programcreek.com/2014/05/leetcode-ugly-number-ii-java/
//20200811
class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int j = 0;
        int i = 0;
        int k = 0;
        
        while (list.size() < n) {
            int m2 = list.get(i) * 2;
            int m3 = list.get(j) * 3;
            int m5 = list.get(k) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2)
                i++;
            if (min == m3)
                j++;
            if (min == m5)
                k++;
        }
        return list.get(list.size() - 1);
    }
    
    
}