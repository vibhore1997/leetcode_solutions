class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length == 1) {
            return strs[0];
        }
        
        for(int p = 0; p<201; p++) {
            for(int i=0; i<strs.length-1; i++) {
               
               if (p >= strs[i].length() || p >= strs[i+1].length()) {
                   return sb.toString();
               } 
               if (strs[i].charAt(p) != strs[i+1].charAt(p)) {
                   return sb.toString();
               }
          }
         sb.append(strs[0].charAt(p));
        }
        return sb.toString();
    }
}