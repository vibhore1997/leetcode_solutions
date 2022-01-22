class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        
        Map<String, Integer> hmap = new HashMap<>();
        
        for (int i=0; i<words.length; i++) {
            hmap.put(words[i], hmap.getOrDefault(words[i], 0) + 1);
        }
        
        Queue<String> heap = new PriorityQueue<>((a,b) -> {
            if (hmap.get(a) == hmap.get(b)) {
                return b.compareTo(a);
            } else {
                return hmap.get(a) - hmap.get(b);
            }
        });
        
        for (String s : hmap.keySet()) {
            if (heap.size() < k) {
                heap.offer(s);
            } else {
                if (hmap.get(s) > hmap.get(heap.peek())) {
                    heap.poll();
                    heap.offer(s);
                } else if (hmap.get(s) == hmap.get(heap.peek())) {
                    if (s.compareTo(heap.peek()) < 0) { // means lexicographically small, the coming string
                        heap.poll();
                        heap.offer(s);
                    }
            }
        }
    }
     
        while (heap.size() != 0) {
            ans.add(heap.poll());
        }
        
        Collections.reverse(ans);
        return ans;
 }
}