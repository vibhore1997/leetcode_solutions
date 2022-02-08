class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) {
            return 0;
        }
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<sticks.length; i++)
            queue.offer(sticks[i]);
        
        int cost = 0;
        
        while(queue.size() != 1) {
            int a = queue.poll();
            int b = queue.poll();
            cost += a + b;
            queue.offer(a+b);
        }
        return cost;
    }
}