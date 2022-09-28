class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        
        int l = 0;
        int r = 0;
        int count[] = new int[256];
        int res = 0;
        
        while (r < s.length()) {
            if (count[s.charAt(r)] > 0) {
                while(s.charAt(l) != s.charAt(r)) {
                    count[s.charAt(l)]--;
                    l++;
                }
                count[s.charAt(l)]--;
                    l++;
            }
            
            count[s.charAt(r)]++;
            r++;
            res = Math.max(res, r - l);
        }
        return res;
        
    }
}