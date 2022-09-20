class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();
        
        for (int i = 0; i< nums.length; i++) {
            hmap.put(nums[i], i);
        }
        
        for (int i=0; i<nums.length; i++) {
            int val = target - nums[i];
            
            if (hmap.containsKey(val) && hmap.get(val) != i) {
                return new int[]{i, hmap.get(val)};
            }
        }
        return new int[]{0,0};
    }
}