class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] maxleft = new int[n];
        int[] maxright = new int[n];
        
        maxleft[0] = height[0];
        
        for (int i=1; i < n; i++) {
            maxleft[i] = Math.max(height[i], maxleft[i-1]);
        }
        
        maxright[n-1] = height[n-1];
        
        for (int i=n-2; i>=0; i--) {
            maxright[i] = Math.max(height[i], maxright[i+1]);
        }
        
        int water = 0;
        
        for (int i=0; i<n; i++) {
            water += Math.min(maxleft[i], maxright[i]) - height[i];
        }
        
        return water;
    }
}