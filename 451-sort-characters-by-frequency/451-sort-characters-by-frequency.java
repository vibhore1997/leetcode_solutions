class Solution {
    public String frequencySort(String s) {
        if (s == null){
            return null;
        }
        
        Map<Character, Integer> hmap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hmap.entrySet());
        
        Collections.sort(list, (a,b) -> {
            return b.getValue() - a.getValue();
        });
        
        StringBuilder res = new StringBuilder();
        
        for (Map.Entry<Character, Integer> entry : list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
            res.append(sb.toString());
        }
        
        return res.toString();
        
  }
}