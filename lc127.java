
//credit by : https://www.cnblogs.com/Dylan-Java-NYC/p/4886846.html
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (wordList == null || wordList.size() == 0)
            return 0;
        

        //List to HashSet
        HashSet<String> dic = new HashSet<>();
        dic.addAll(wordList);
        
        if (!dic.contains(endWord))
            return 0;
        
        int level = 1;
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return level;
                }
                
                for (int i = 0; i < cur.length(); i++) {
                    char[] arr = cur.toCharArray();
                    char ori = arr[i];
                
                    for(char c ='a'; c <= 'z'; c++) {
                        if (ori == c) {
                            continue;
                        }
                        arr[i] = c;

                        String newWord = new String(arr);
                        if (dic.contains(newWord)) {
                            queue.add(newWord);
                            dic.remove(newWord);
                        }
                      
                    }
                }
            } 
            level++;
        }
        
        return 0;
    }
}