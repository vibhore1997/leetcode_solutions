class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        int count = 0;
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() + count;
    }
}