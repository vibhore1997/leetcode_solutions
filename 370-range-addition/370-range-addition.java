class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int res[] = new int[length];
        
        for(int i=0; i<updates.length; i++) {
            int value = updates[i][2];
            int start = updates[i][0];
            int end = updates[i][1];
            
            res[start] += value;
            
            if (end + 1 < length) {
                res[end+1] += -1 * value; 
            }
        }
        
        for(int i=1; i<length; i++) {
            res[i] += res[i-1]; 
        }
        return res;
    }
}