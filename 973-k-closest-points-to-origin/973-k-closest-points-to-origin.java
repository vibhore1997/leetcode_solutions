class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }
        
        Map<Integer, Integer> hmap = new HashMap<>();
        
        for(int i = 0; i<points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            hmap.put(i, dist);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> hmap.get(b) - hmap.get(a));
        
        for (int i = 0; i<points.length; i++) {
            if (queue.size() < k) {
                queue.offer(i);
            } else {
                if (hmap.get(i) < hmap.get(queue.peek())) {
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        
        int[][] ans = new int[k][2];
        int j = 0;
        while (queue.size() > 0) {
            ans[j++] = points[queue.poll()];
        }
        return ans;
    }
}