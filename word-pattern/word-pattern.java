class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> hmap = new HashMap<>();
        String[] arr = s.split(" ");
        
        if (pattern.length() != arr.length) {
            return false;
        }
        
        for (int i = 0; i<pattern.length(); i++) {
            if (hmap.containsKey(pattern.charAt(i))) {
                String temp = hmap.get(pattern.charAt(i));
                
                if (!temp.equals(arr[i])) {
                    return false;
                }
            } else {
                hmap.put(pattern.charAt(i), arr[i]);
            }
        }
        
        Map<String, Character> hmap1 = new HashMap<>();
        
        for (int i = 0; i<arr.length; i++) {
            if (hmap1.containsKey(arr[i])) {
                char temp = hmap1.get(arr[i]);
                
                if (temp != pattern.charAt(i)) {
                    return false;
                }
            } else {
                hmap1.put(arr[i], pattern.charAt(i));
            }
        }
        return true;
    }
}