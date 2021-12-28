class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int pivot = 0;
        
        while (l <= h) {
            int m = l + (h-l)/2;
            
            if (nums[(m+1) % nums.length] > nums[m] && m > 0 && nums[m-1] > nums[m]) {
                pivot = m;
                break;
            } else if (nums[(m+1) % nums.length] > nums[m] && m == 0 && nums[nums.length - 1] > nums[m]) {
                pivot = m;
                break;
            } else {
                if (nums[m] > nums[0]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        
        if (nums[pivot] == target) {
            return pivot;
        }
        
        if (target > nums[nums.length - 1]) {
            l = 0;
            h = pivot - 1;
        } else {
            l = pivot + 1;
            h = nums.length - 1;
        }
        
        while (l <= h) {
            int m = l + (h-l)/2;
            
            if(nums[m] > target) {
                h = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else if(nums[m] == target) {
                return m;
            }
        }
        return -1;
        
    }
}