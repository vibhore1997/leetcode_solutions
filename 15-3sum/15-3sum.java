class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length; i++) {
            if ( i > 0 && nums[i] == nums[i-1])
                continue;
            
            if (nums[i] > 0) {
                break;
            }
            
            int target = -1 * nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                int sum = nums[l] + nums[r];
                
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    list.add(temp);
                    
                    l++;
                    
                    while (nums[l] == nums[l-1] && l < r) {
                        l++;
                    }
                }
            }
            
        }
        
        return list;
    }
}