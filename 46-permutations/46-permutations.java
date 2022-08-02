class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        track(nums, ans, used, new ArrayList<Integer>());
        return ans;
    }
    
    private void track(int[] nums,  List<List<Integer>> ans, boolean[] used, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                track(nums, ans, used, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}