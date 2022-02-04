class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> a - b); // end times
        queue.offer(intervals[0][1]);
        
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
                queue.offer(intervals[i][1]);
            } else {
                queue.offer(intervals[i][1]);
            }
        }
        
        return queue.size();
    }
}