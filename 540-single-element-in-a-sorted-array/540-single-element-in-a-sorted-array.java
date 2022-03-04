class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        
        while (l < h) {
            int m = l + (h - l)/2;
            
            if (nums[m] == nums[m-1]) {
            if ((h-m) % 2 == 0) { // even halfs
                    h = m - 2;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] == nums[m+1]) {
                if ((h-m) % 2 == 0) {
                     l = m + 2;
                } else {
                    h = m - 1;
                }
            } else {
                return nums[m];
            }
        }
        return nums[l];
    }
}