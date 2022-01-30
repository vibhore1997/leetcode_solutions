class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) return false;
        
        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        int sum = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            sum = sum % k;
            
            if (hmap.containsKey(sum)) {
                if (i - hmap.get(sum) > 1) {
                    return true;
                }
            }
            else {
              hmap.put(sum, i);  
            }
        }
        return false;
    }
}