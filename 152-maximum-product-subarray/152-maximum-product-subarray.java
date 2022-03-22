class Solution {
    public int maxProduct(int[] nums) {
        // int res = -20;
        // for (int i=0; i<nums.length; i++) {
        //     int prod = 1;
        //     for(int j=i; j<nums.length; j++) {
        //         prod = prod * nums[j];
        //         res = Integer.max(res, prod);
        //         if (prod == 0) {
        //             break;
        //         }
        //     }
        // }
        // return res;
        
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int res = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(nums[i] * max_so_far, nums[i] * min_so_far));
            
            min_so_far = Math.min(nums[i], Math.min(nums[i] * max_so_far, nums[i] * min_so_far));
            
            max_so_far = temp;
            
            res = Math.max(res, max_so_far);
        }
        return res;
    }
}