class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<lower.length(); i++) {
            if ((lower.charAt(i) >= 'a' && lower.charAt(i) <= 'z') || (lower.charAt(i) >= '0' && lower.charAt(i) <= '9')) {
                sb.append(lower.charAt(i));
        }
    }
        
        for (int i=0, j = sb.length() - 1; i < j; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }
 return true;       
}
}