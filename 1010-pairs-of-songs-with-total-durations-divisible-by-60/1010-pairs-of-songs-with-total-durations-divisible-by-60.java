class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count[] = new int[60];
        int res = 0;
        
        for (int i = 0; i<time.length; i++) {
            if (time[i] % 60 == 0) {
                res += count[0];
            } else {
                res += count[60 - (time[i] % 60)];
            }
            
            count[time[i] % 60]++; 
        }
        return res;
    }
}