class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        Map<String, List<String>> hmap = new HashMap<>();
        
        for(int i=0; i<strs.length; i++) {
            int count[] = new int[26];
            
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<26; j++) {
                sb.append(count[j]);
                sb.append('#');
            }
            
            if(!hmap.containsKey(sb.toString())) {
                hmap.put(sb.toString(), new ArrayList());
            }
            
            hmap.get(sb.toString()).add(strs[i]);
        }
        
        return new ArrayList<>(hmap.values());
    }
}