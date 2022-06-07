class Solution {
    public boolean isIsomorphic(String s, String t) {
        return iso(s,t) && iso(t,s);
    }
    
    public boolean iso(String s, String t) {
        HashMap<Character, Character> hmap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            if (hmap.containsKey(s.charAt(i))) {
                if (t.charAt(i) != hmap.get(s.charAt(i))) {
                    return false;
                }
            } else {
                hmap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}