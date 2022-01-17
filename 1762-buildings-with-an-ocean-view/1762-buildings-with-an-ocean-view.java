class Solution {
    public int[] findBuildings(int[] heights) {
        int[] arr = new int[heights.length];
        int maxi = heights[heights.length - 1];
        int idx = heights.length - 1;
        
        int count = 1;
        arr[heights.length - 1] = 1;
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > heights[i+1]) {
                // maxi = Math.max(maxi, heights[i]);
                if (heights[i] > maxi) {
                    maxi = heights[i];
                    idx = i;
                }
                
                if (idx == i || heights[i] > maxi) {
                    arr[i] = 1;
                    count++;
                }
            }
        }
        
        int j = 0;
        int res[] = new int[count];
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == 1) {
                res[j++] = i;
            }
        }
        return res;
    }
}