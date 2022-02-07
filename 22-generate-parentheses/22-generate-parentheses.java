class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, new StringBuilder(), 0, 0, n);
        return list;
    }
    
    private void helper(List<String> list, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == 2 * max) {
            list.add(sb.toString());
            return;
        }
        
        if (open < max) {
            sb.append("(");
            helper(list, sb, open + 1, close, max);
            sb.setLength(sb.length() - 1);
        }
        
        if (close < open) {
            sb.append(")");
            helper(list, sb, open, close + 1, max);
            sb.setLength(sb.length() - 1);
        }
    }
}