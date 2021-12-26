class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == k) {
                total++;
            }
            int sum = nums[i];
            for(int j = i+1; j<nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    total++;
                }
            }
        }
        return total;
    }
}