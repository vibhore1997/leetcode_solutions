class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int res[] = new int[nums.length - k + 1];
        
        int i = 0;
        int j = 0;
        
        while (j < nums.length) {
            
            while (!queue.isEmpty() && nums[j] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offer(j);
            
            if (j - i + 1 < k) { // j - i + 1 is window size
                j++;
            } else {
                res[i] = nums[queue.peek()];
                
                if (queue.peek() == i) {
                    queue.poll();
                }
                
                i++;
                j++;
            }
        }
        return res;
    }
}