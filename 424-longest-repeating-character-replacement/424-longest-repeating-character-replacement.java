class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0;
        int end = 0;
        int mostFreqLetter = 0;
        int res = 0;
        
        while (end < s.length()) {
            count[s.charAt(end) - 'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, count[s.charAt(end) - 'A']);
            
            int lengthOfSub = end - start + 1;
            if (lengthOfSub - mostFreqLetter > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, end - start + 1);
            
            end++;
        }
        return res;
    }
}