//https://www.youtube.com/watch?v=84xibeO_lqk
//google
// priorityQueue  maxheap  O(nlogn)

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < labels.length; i++) {
            items.add(new Item(values[i], labels[i]));
        }
        
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((Item a, Item b) -> b.value - a.value);
        maxHeap.addAll(items);
        
        Map<Integer, Integer> counts = new HashMap<>();
        int res = 0;
        while (!maxHeap.isEmpty() && num_wanted > 0) {
            Item curr = maxHeap.remove();
            counts.put(curr.label, counts.getOrDefault(curr.label, 0) + 1);
            if (counts.get(curr.label) <= use_limit) {
                res += curr.value;
                num_wanted--;
            }
        }
        return res;
        
    }
    class Item {
        int value;
        int label;
        
        public Item (int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}