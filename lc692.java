class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        List<String> res = new ArrayList<>();
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            //pq.offer(word);
        }
        
        for (String s : map.keySet()) {
            pq.offer(s);
        }
        
        while (res.size() < k) {
            res.add(pq.poll());
        }
        return res;
        
    }
}