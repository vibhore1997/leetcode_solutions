class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        helper(res, new ArrayList<>(), used, nums);
        return res;
    }
    
    void helper(List<List<Integer>> res, List<Integer> list, boolean[] used, int[] nums) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                list.add(nums[i]);
                helper(res, list, used, nums);
                
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}