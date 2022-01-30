class Solution {
    public String customSortString(String order, String s) {
        int count[] = new int[26];
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < order.length(); i++) {
            while (count[order.charAt(i) - 'a'] > 0) {
                sb.append(order.charAt(i));
                count[order.charAt(i) - 'a']--;
            }
        }
        
        for (int i=0; i<count.length; i++) {
            while (count[i] > 0) {
                sb.append((char)('a' + i));
                count[i]--;
            }
        }
        
        return sb.toString();
    }
}