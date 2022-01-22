class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergesort(int nums[], int l, int h) {
        if (l < h) {
            int mid = (l+h)/2;
            mergesort(nums, l, mid);
            mergesort(nums, mid+1, h);
            merge(nums, l, mid, h);
        }
    }
    
    private void merge(int nums[], int l, int mid, int h) {
        int[] b = new int[h-l+1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        
        while(i <= mid && j <= h) {
            if (nums[i] < nums[j]) {
                b[k++] = nums[i++];
            } else {
                b[k++] = nums[j++];
            }
        }
        
        while(i <= mid) {
            b[k++] = nums[i++];
        }
        while (j <= h) {
            b[k++] = nums[j++];
        }
        
        for (int p = 0; p<k; p++)
            nums[l++] = b[p];
    }
}