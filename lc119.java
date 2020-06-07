//https://blog.csdn.net/fuxuemingzhu/article/details/51348629

class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
 
	if (rowIndex < 0)
		return result;
 
	result.add(1);
	for (int i = 1; i <= rowIndex; i++) {
		for (int j = result.size() - 2; j >= 0; j--) {
			result.set(j + 1, result.get(j) + result.get(j + 1));
		}
		result.add(1);
	}
	return result;
    }
}


/**
1
1 1

   res.size() - 2         res.size() - 1 
1             2               1
              j               j + 1

1  2   3   
      j + 1

1   2    3
j  j+ 1

1   3    3
   j + 1



1  3  3
1  3  3  1  

*/ 
