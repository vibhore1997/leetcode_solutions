class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hmap = new HashMap<>();
        
        for (int i=0; i<strs.length; i++) {
            int count[] = new int[26];
            
            for (int j=0; j<strs[i].length(); j++) {
                count[strs[i].charAt(j) - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for (int j=0; j<count.length; j++) {
                sb.append(count[j]);
                sb.append("#");
            }
            String exp = sb.toString();
            
            if (hmap.containsKey(exp)) {
                List<String> list = hmap.get(exp);
                list.add(strs[i]);
                hmap.put(exp, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hmap.put(exp, list);
            }
        }
        
        return new ArrayList<>(hmap.values());
    }
}