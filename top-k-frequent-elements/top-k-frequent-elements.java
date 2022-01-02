class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> {
            // if (hmap.get(a) == null || hmap.get(b) == null) {
            //     return 0;
            // }
            return hmap.get(a) - hmap.get(b);
        });
        
        for (int i = 0; i<nums.length; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int ele : hmap.keySet()) {
            if (queue.size() < k) {
                queue.offer(ele);
            } else {
                if (hmap.get(ele) > hmap.get(queue.peek())) {
                    queue.poll();
                    queue.offer(ele);
                }
            }
        }
        
        int arr[] = new int[k];
        int j = 0;
        for (int i : queue) {
            arr[j++] = i;
        }
        return arr;
    }
}