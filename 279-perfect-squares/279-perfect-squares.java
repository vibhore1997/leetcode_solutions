class Solution {
    public int numSquares(int n) {
      List<Integer> squares = new ArrayList<>();
        
        for (int i=1; i*i <= n; i++) {
            squares.add(i*i);
        }
        
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        
        while (queue.size() > 0) {
            level++;
            
            Set<Integer> newQueue = new HashSet<>();
            
            for (int ele : queue) {
                for (int sq : squares) {
                    if (ele - sq == 0) {
                        return level;
                    } else if(ele < sq) {
                      break;  
                    } else {
                        newQueue.add(ele - sq);
                    }
                }
            }
            queue = newQueue;
        }
        return level;
    }
}