// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> result = new ArrayList<>();
//         int i = 0, j = 0;
//         int k = p.length();
//         Map<Character, Integer> hmap = new HashMap<>();
//         for (char c : p.toCharArray()) {
//             hmap.put(c, hmap.getOrDefault(c, 0) + 1);
//         }
//         Map<Character, Integer> map2 = new HashMap<>();
//         while (j < s.length()) {
//             if (j < k-1) {
//                 map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0) + 1);
//                 j++;
//             } else {
//                 map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0) + 1);
                
//                 if (hmap.equals(map2)) {
//                     result.add(i);
//                 }
                
//                 if (map2.get(s.charAt(i)) == 1) {
//                     map2.remove(s.charAt(i));
//                 } else {
//                     map2.put(s.charAt(i), map2.get(s.charAt(i)) - 1);
//                 }
                
//                 i++;
//                 j++;
//             }
//         }
//         return result;
//     }
// }

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int k = p.length();
        Map<Character, Integer> hmap = new HashMap<>();
        for (char c : p.toCharArray()) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
       int count = hmap.size();
        while (j < s.length()) {
            if (j < k-1) {
                char c = s.charAt(j);
                if (hmap.containsKey(c)) {
                    hmap.put(c, hmap.get(c) - 1);
                    if (hmap.get(c) == 0) {
                        count--;
                    }
                }
                j++;
                
            } else {
                char c = s.charAt(j);
                if (hmap.containsKey(c)) {
                    hmap.put(c, hmap.get(c) - 1);
                    if (hmap.get(c) == 0) {
                        count--;
                    }
                }
                
                if (count == 0) {
                    result.add(i);
                }
                
                if (hmap.containsKey(s.charAt(i))) {
                    int value = hmap.get(s.charAt(i));
                    hmap.put(s.charAt(i), value + 1);
                    if (value + 1 == 1) {
                        count++;
                    }
                }
                
                i++;
                j++;
            }
        }
        return result;
    }
}