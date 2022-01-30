class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        
        int k = 0;
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                k = i;
                break;
            }
        }
        
        if (k == 0) return num;
        
        char max = '0';
        int pos = 0;
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                pos = i;
            }
        }
        
        for (int i=0; i<k; i++) {
            if (max > nums[i]) {
                char temp = nums[i];
                nums[i] = max;
                nums[pos] = temp;
                return Integer.valueOf(String.valueOf(nums));
            }
        }
        
        return num;
    }
}