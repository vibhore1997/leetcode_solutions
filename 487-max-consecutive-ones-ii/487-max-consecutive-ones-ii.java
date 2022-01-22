class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int idx = -1;
        int cnt = 0;
        int res = 0;
        
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = i - idx;
                idx = i;
            }
            res = Math.max(cnt, res);
        }
        return res;
    }
}