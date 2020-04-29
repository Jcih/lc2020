class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        //sort the map by value descending
        
        //List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        //list.sort(Map.Entry.comparingByValue());// how to reverse sort map by value
        //Collections.sort(list, Collections.reverseOrder()); 


        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        
        /*
        Map<Integer, Integer> sorted_map = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sorted_map.put(entry.getKey(), entry.getValue());
        }
        */
        
        List<Integer> res = new ArrayList<>();
        /*
        int i = 0;
        for (HashMap.Entry<Integer, Integer> entry: sorted_map.entrySet()) {
            if (i < k) {
               res.add(entry.getKey());
                i++;
            }
        }
        */
        
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }
}