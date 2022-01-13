class Solution {

    int prefix[];
    Random rand = new Random();
    public Solution(int[] w) {
       prefix = new int[w.length];
        
        prefix[0] = w[0];
        for(int i=1; i<w.length; i++) {
            prefix[i] = prefix[i-1] + w[i];
          }
    }
    
    public int pickIndex() {
        int pick = rand.nextInt(prefix[prefix.length - 1]) + 1;
        
        int low = 0;
        int res = -1;
        int high = prefix.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (pick == prefix[mid]) {
                return mid;
            } else if (pick > prefix[mid]) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */