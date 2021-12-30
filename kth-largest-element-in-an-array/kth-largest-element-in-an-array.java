class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(); // Min Heap
        
        for(int i=0; i<nums.length; i++) {
            if (i < k) {
              pq.offer(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}