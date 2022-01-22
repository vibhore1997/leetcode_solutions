class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int res[] = new int[nums.length - k + 1];
        
        int i = 0;
        int j = 0;
        
        while (j <= nums.length) {
            if (j < k) {
                while (!queue.isEmpty() && nums[j] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offer(j);
                j++;
            } else {
                res[i] = nums[queue.peek()];
                
                if (queue.peek() == i) {
                    queue.poll();
                }
                
                if (j == nums.length) break;
                
                while (!queue.isEmpty() && nums[j] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offer(j);
                
                i++;
                j++;
            }
        }
        return res;
    }
}