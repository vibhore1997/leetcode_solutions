class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // this is similar as range addition in an array (+ and - at start and end)
        // Can use TreeMap, if range is not small.
        
        int[] count = new int[1001];
        
        for (int i=0; i<trips.length; i++) {
            count[trips[i][1]] += trips[i][0];
            count[trips[i][2]] -= trips[i][0];
        }
        
        int currCapacity = 0;
        
        for (int i=0; i<1001; i++) {
            currCapacity += count[i];
            if (currCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}