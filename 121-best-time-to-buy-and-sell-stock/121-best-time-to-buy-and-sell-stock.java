class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int res = 0;
        
        for (int i=1; i<prices.length; i++) {
          if (prices[i] < min) {
              min = prices[i];
              max = prices[i];
          } else {
              max = Math.max(max, prices[i]);
          }
            res = Math.max(res, max - min);
        }
        
        return res;
    }
}