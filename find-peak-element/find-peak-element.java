class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        
        if (nums.length == 1) {
            return 0;
        }
        
        while (l <= h) {
            int m = (l+h)/2;
            
            if (m == nums.length - 1 && nums[m] > nums[m-1]) {
                return m;
            } else if (m == 0 && nums[m] > nums[m+1]) {
                return m;
            } else if (m > 0 && m < nums.length - 1 && nums[m] > nums[m-1] && nums[m] > nums[m+1]) {
                return m;
            } else {
                if (nums[m+1] > nums[m]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return 0;
    }
}