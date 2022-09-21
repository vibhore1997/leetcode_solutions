class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arr[] = new int[nums.length];
        
        int a = nums[0];
        arr[0] = 1;
        
        for(int i=1; i<nums.length; i++) {
            arr[i] = arr[i-1] * a;
            a = nums[i];
        }
        
        a = nums[nums.length - 1];
        
        for (int i = nums.length - 2; i >= 0; i--) {
            arr[i] = arr[i] * a;
            a = nums[i] * a;
        }
        
        return arr;
    }
}