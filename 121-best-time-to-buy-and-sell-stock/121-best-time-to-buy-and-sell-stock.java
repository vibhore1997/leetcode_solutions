class Solution {
    public int maxProfit(int[] prices) {
        int min = 100000;
        int max = 0;
        
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}