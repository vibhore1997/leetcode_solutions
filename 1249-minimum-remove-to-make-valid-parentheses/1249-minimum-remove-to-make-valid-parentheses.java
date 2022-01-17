class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> hs = new HashSet<>();
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    hs.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        while (!stack.isEmpty()) {
            hs.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<s.length(); i++) {
            if (hs.contains(i)) {
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}