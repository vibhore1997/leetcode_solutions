class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hmap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                hmap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        int res[] = new int[nums1.length];
        
        for (int i=0; i<nums1.length; i++) {
            if (hmap.containsKey(nums1[i])) {
                res[i] = hmap.get(nums1[i]);
            } else {
                res[i] = -1;
            }
        }
        
        return res;
    }
}