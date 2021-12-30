// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         Map<Character, Integer> hmaps = new LinkedHashMap<>();
//         Map<Character, Integer> hmapt = new LinkedHashMap<>();
        
//         for (char c : s.toCharArray()) {
//             hmaps.put(c, hmaps.getOrDefault(c, 0) + 1);
//         }
        
//         for (char c : t.toCharArray()) {
//             hmapt.put(c, hmapt.getOrDefault(c, 0) + 1);
//         }
        
//         if(hmaps.size() != hmapt.size()) {
//             return false;
//         }
        
//         List<Integer> list1 = new ArrayList<>(hmaps.values());
//         List<Integer> list2 = new ArrayList<>(hmapt.values());
        
//         for (int i = 0; i<list1.size(); i++) {
//             if (list1.get(i) != list2.get(i)) {
//                 return false;
//             }
//         }
//         return true;
        
//     }
// }

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hmap1 = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            hmap1.put(s.charAt(i), t.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            sb.append(hmap1.get(c));
        }
        
        
        Map<Character, Character> hmap2 = new HashMap<>();
        
        for (int i=0; i<t.length(); i++) {
            hmap2.put(t.charAt(i), s.charAt(i));
        }
        
        StringBuilder sbNew = new StringBuilder();
        
        for(char c : t.toCharArray()) {
            sbNew.append(hmap2.get(c));
        }
        return sb.toString().equals(t) && sbNew.toString().equals(s);
    }
}