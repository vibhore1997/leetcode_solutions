class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        int curr = 0;
        char op = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) {
                curr = curr * 10 + c - '0';
            }
            if (!(c - '0' >= 0 && c - '0' <= 9) && c != ' ' || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(curr);
                } else if (op == '-') {
                    stack.push(-curr);
                } else if (op == '*') {
                    stack.push(stack.pop() * curr);
                } else if (op == '/') {
                    stack.push(stack.pop() / curr);
                }
                
                op = c;
                curr = 0;
            }
        }
        
        int res = 0;
        while (stack.size() > 0) {
            res += stack.pop();
        }
        return res;
        
    }
}