class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        
        if (nums[l] <= nums[h]) {
            return nums[l];
        }
        // if (nums.length == 2) {
        //     return nums[1];
        // }
        
        while (l <= h) {
            int m = l + (h-l)/2;
            
            if (nums[(m+1) % nums.length] > nums[m] && m > 0 && nums[m-1] > nums[m]) {
                return nums[m];
            } else if (nums[(m+1) % nums.length] > nums[m] && m == 0 && nums[nums.length - 1] > nums[m]) {
                return nums[m];
            } else {
                if (nums[m] >= nums[0]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return 0;
    }
}