class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return 1;
        
        Set<Integer> hs = new HashSet<>();
        
        for (int i : nums) {
            hs.add(i);
        }
        
        int ans = 0;
        
        for (int ele : hs) {
            if (!hs.contains(ele - 1)) {
                int temp = 1;
                int num = ele;
                
                while (hs.contains(num + 1)) {
                    temp++;
                    num++;
                }
                
                ans = Math.max(ans, temp);
            }
        }
        
        return ans;
    }
}