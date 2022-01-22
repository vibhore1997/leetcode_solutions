class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<res.length; i++) {
            res[i] = -1;
        }
        
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            if (i < nums.length) stack.push(i);
        }
        return res;
    }
}