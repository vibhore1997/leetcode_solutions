class Solution {
    public int[] findBuildings(int[] heights) {
        int[] arr = new int[heights.length];
        int maxi = -1;
        int count = 0;
        
        for (int i = heights.length - 1; i >= 0; i--) {
    
                if (heights[i] > maxi) {
                    arr[i] = 1;
                    maxi = heights[i];
                    count++;
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