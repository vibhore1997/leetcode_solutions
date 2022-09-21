class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> hmap.get(a) - hmap.get(b));
        
        for (int ele : hmap.keySet()) {
            if (heap.size() < k) {
                heap.offer(ele);
            } else if (hmap.get(ele) > hmap.get(heap.peek())) {
                    heap.poll();
                    heap.offer(ele);
            }
        }
        
        int arr[] = new int[heap.size()];
        int p = 0;
        while (heap.size() > 0) {
            arr[p++] = heap.poll();
        }
        
        return arr;
    }
}