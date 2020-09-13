//https://www.youtube.com/watch?v=zaM_GLLvysw
//Amazon, FACEBOOK

//priorityQueue, O(nlogn)
class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            counts.put(S.charAt(i), counts.getOrDefault(S.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());
        
        StringBuilder res = new StringBuilder();
        while (maxHeap.size() > 1) {
            char cur = maxHeap.remove();
            char next = maxHeap.remove();
            
            res.append(cur);
            res.append(next);
            
            counts.put(cur, counts.get(cur) - 1);
            counts.put(next, counts.get(next) - 1);
            if (counts.get(cur) > 0) {
                maxHeap.add(cur);
            }
            if (counts.get(next) > 0) {
                maxHeap.add(next);
            }
        }
        
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (counts.get(last) > 1)
                return "";
            
            res.append(last);
        }
        return res.toString();
        
    }
}