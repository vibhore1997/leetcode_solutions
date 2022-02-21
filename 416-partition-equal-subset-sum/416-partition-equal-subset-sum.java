class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+= nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        Map<String, Boolean> hmap = new HashMap<>();
        
        return helper(nums, 0, 0, sum/2, hmap);
    }
    
    private boolean helper(int[] nums, int index, int currSum, int target, Map<String, Boolean> hmap) {
        
        if (currSum > target) {
            return false;
        }
        
        if (currSum == target) {
            return true;
        }
        
        if (index == nums.length) {
            return false;
        }
        
        String A = new String(index+"#"+currSum);
        // System.out.println(A);
        if (hmap.containsKey(A)) {
            return hmap.get(A);
        }
        
        boolean flag = false;
        
        flag |= helper(nums, index + 1, currSum + nums[index], target, hmap);
        if (flag) {
            hmap.put(A, flag);
            return flag;
        }
        flag |= helper(nums, index + 1, currSum, target, hmap);
        
        hmap.put(A, flag);
        return flag;
        
    }
}