class Solution {
    public boolean isAnagram(String s, String t) {
//         int arr[] = new int[26];
        
//         if (s.length() != t.length())
//             return false;
        
//         for(int i=0 ; i < s.length(); i++) {
//             arr[s.charAt(i) - 'a']++;
//             arr[t.charAt(i) - 'a']--;
//         }
        
//         for(int i=0; i< arr.length; i++) {
//             if (arr[i] != 0) {
//                 return false;
//             }
//         }
        
//         return true;
        
        
        if (s.length() != t.length())
            return false;
        
        Map<Character, Integer> hmap = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int i=0; i<t.length(); i++) {
            if (hmap.containsKey(t.charAt(i))) {
                int val = hmap.get(t.charAt(i));
                val--;
                if (val == 0) {
                    hmap.remove(t.charAt(i));
                } else {
                    hmap.put(t.charAt(i), val);
                }
            } else {
                return false;
            }
        }
        
        if (hmap.size() == 0) {
            return true;
        }
        return false;
    }
}