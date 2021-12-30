class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        int length = 0;
        boolean odd = false;
        for(char c : s.toCharArray()) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        
        for(int i : hmap.values()) {
            if(i % 2 == 0) {
                length += i;
            } else {
                odd = true;
                length += i - 1;
            }
        }
        
        return odd ? length + 1 : length;
    }
}