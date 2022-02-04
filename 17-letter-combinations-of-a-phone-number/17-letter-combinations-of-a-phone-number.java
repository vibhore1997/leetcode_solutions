class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> hmap = new HashMap<>();
        hmap.put(2, "abc");
        hmap.put(3, "def");
        hmap.put(4, "ghi");
        hmap.put(5, "jkl");
        hmap.put(6, "mno");
        hmap.put(7, "pqrs");
        hmap.put(8, "tuv");
        hmap.put(9, "wxyz");
        
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        } 
        
        backtrack(digits, hmap, sb, res, 0);
        
        return res;
    }
    
    void backtrack(String digits, Map<Integer, String> hmap, StringBuilder sb, List<String> res, int pos) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String options = hmap.get(digits.charAt(pos) - '0');
        for (int i=0; i<options.length(); i++) {
            sb.append(options.charAt(i));
            backtrack(digits, hmap, sb, res, pos + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}