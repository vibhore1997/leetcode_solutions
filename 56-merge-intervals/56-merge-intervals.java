class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        
        for(int i = 1; i<intervals.length; i++) {
            int[] top = stack.pop();
                if (top[1] >= intervals[i][0]) {
                    if (top[1] >= intervals[i][1]) {
                        stack.push(top);
                    } else {
                        stack.push(new int[]{top[0], intervals[i][1]});
                    }
                } else {
                    stack.push(top);
                    stack.push(new int[]{intervals[i][0], intervals[i][1]});
                }
        }
        
        int res[][] = new int[stack.size()][2];
        int k = 0;
        
        while (stack.size() != 0) {
            res[k++] = stack.pop();
        }
        
        for (int i=0, j = res.length - 1; i < j; i++, j--) {
            int[] temp = res[i];
            res[i] = res[j];
            res[j] = temp;
        }
        
        return res;
    }
}