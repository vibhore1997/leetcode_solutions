class Solution {
    public int maxProfit(int[] prices) {
        int min = 100000;
        int max = -1;
        int ans = -1;
        
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }
            ans = Math.max(ans, max - min);
        }
        return ans;
    }
}