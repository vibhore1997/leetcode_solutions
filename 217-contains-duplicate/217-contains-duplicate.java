class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean ans = false;
        Set<Integer> hs = new HashSet<>();
        
        for (int i : nums) {
            if (hs.contains(i)) {
                ans = true;
                break;
            }
            hs.add(i);
        }
        return ans;
    }
}