class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        
        for(int i=0; i<haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int start = i;
                for(int j = 0; j<needle.length(); j++) {
                    if (start == haystack.length()) {
                        return -1;
                    }
                    if(needle.charAt(j) != haystack.charAt(start)) {
                        break;
                    }
                    start++;
                }
                if(start - i == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}