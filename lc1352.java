
//Solution I brute force Time Limit Exceed
class ProductOfNumbers {

    List<Integer> A;
    public ProductOfNumbers() {
        A = new ArrayList<>();
    }
    
    public void add(int num) {
        A.add(num);
    }
    
    public int getProduct(int k) {
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = res * A.get(A.size() - i - 1);
        }
        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */


//Solution II prefix PRODUCT
//https://leetcode.com/problems/product-of-the-last-k-numbers/discuss/515867/Java-faster-than-98
class ProductOfNumbers {

    List<Integer> A;
    public ProductOfNumbers() {
        A = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) A.clear();
        else {
            A.add(A.size() == 0 ? num : A.get(A.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        if (k > A.size()) return 0;
        if (k == A.size()) return A.get(A.size() - 1);
        return A.get(A.size() - 1) / A.get(A.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */