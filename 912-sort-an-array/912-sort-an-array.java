class Solution {
    public int[] sortArray(int[] nums) {
        // Quicksort
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quicksort(int[] nums, int l, int h) {
        if (l < h) {
            int pivot = partition(nums, l, h);
            quicksort(nums, l, pivot - 1);
            quicksort(nums, pivot + 1, h);
        }
    }
    
    private int partition(int[] nums, int l, int h) {
        int pivotIndex = l;
        int pivot = nums[pivotIndex];
        int i = l;
        int j = h;
        
        while (i < j) {
            while(i < nums.length && nums[i] <= pivot) {
                i++;
            }
            while(j >= 0 && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // swap pivot with j
        
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[j];
        nums[j] = temp;
        
        return j;
        
    }
}