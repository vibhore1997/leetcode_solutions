class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int res[] = {-1,-1};
        
        while (l <= h) {
            int m = l + (h-l)/2;
            
            if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        
        if (l < nums.length && nums[l] == target) res[0] = l;
        
        l = 0;
        h = nums.length - 1;
        
        while (l <= h) {
            int m = l + (h-l)/2;
            
            if (nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        if (h >= 0 && nums[h] == target) res[1] = h;
        
        return res;
    }
}