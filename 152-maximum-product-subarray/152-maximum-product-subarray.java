class Solution {
    public int maxProduct(int[] nums) {
        int res = -20;
        for (int i=0; i<nums.length; i++) {
            int prod = 1;
            for(int j=i; j<nums.length; j++) {
                prod = prod * nums[j];
                res = Integer.max(res, prod);
                if (prod == 0) {
                    break;
                }
            }
        }
        return res;
    }
}