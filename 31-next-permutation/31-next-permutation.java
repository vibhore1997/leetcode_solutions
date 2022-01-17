class Solution {
    public void nextPermutation(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int pos = -2;
        if (nums.length == 1) {
            return;
        }
        
        for (int i = nums.length - 1; i >= 1; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    pos = Math.max(pos, j);
                    hmap.put(i, j);
                    break;
                }
            }
        }
        
        if (pos == -2) {
            Arrays.sort(nums);
            return;
        }
        
        int index = -1;
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (entry.getValue() == pos) {
                index = Math.max(index, entry.getKey());
            }
        }
        
        int temp = nums[pos];
        nums[pos] = nums[index];
        nums[index] = temp;
        
        Arrays.sort(nums, pos + 1, nums.length);
    }
}