class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> hmap = new HashMap<>();
        
        for (char p : t.toCharArray()) {
            hmap.put(p, hmap.getOrDefault(p, 0) + 1);
        }
        
        if (t.length() > s.length()) {
            return "";
        }
        
        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        
        int counter = hmap.size();
        int i = 0, j = 0;
        
        while (j < s.length()) {
            char c = s.charAt(j);
            if (hmap.containsKey(c)) {
                hmap.put(c, hmap.get(c) - 1);
                
                if (hmap.get(c) == 0) {
                    counter--;
                }
            }
                
                while (counter == 0) {
                    
                    if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    start = i;
                    end = j;
                 }
                    
                    char k = s.charAt(i);
                    if (hmap.containsKey(k)) {
                     hmap.put(k, hmap.get(k) + 1);
                
                    if (hmap.get(k) == 1) {
                       counter++;
                        }
                    }
                    i++;
                }
            j++;
        }
        
        if (minLength > 0 && minLength != Integer.MAX_VALUE) {
            StringBuilder sb = new StringBuilder();
            
            for (int k = start; k<= end; k++)
                sb.append(s.charAt(k));
            
            return sb.toString();
        } else {
            return "";
        }
    }
}