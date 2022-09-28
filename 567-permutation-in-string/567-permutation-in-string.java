class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        
        Map<Character, Integer> small = new HashMap<>();
        
        for (char c : s1.toCharArray()) {
            small.put(c, small.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> hmap = new HashMap<>();
        
        int i = 0;
        int j = 0;
        
        while (j <= s2.length()) {
            if (j < s1.length()) {
                hmap.put(s2.charAt(j), hmap.getOrDefault(s2.charAt(j), 0) + 1);
                j++;
            } else {
                if (hmap.equals(small))
                    return true;
                
                if (j == s2.length()) break;
                
                int val = hmap.get(s2.charAt(i));
                val--;
                
                if (val == 0)
                    hmap.remove(s2.charAt(i));
                else
                    hmap.put(s2.charAt(i), val);
                
                hmap.put(s2.charAt(j), hmap.getOrDefault(s2.charAt(j), 0) + 1);
                
                i++;
                j++;
            }
        }
        
        return false;
    }
}