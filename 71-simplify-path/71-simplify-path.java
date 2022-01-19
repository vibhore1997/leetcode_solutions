class Solution {
    public String simplifyPath(String path) {
        String[] comp = path.split("/");
        Stack<String> stack = new Stack<>();
        
        
        for (String ele : comp) {
            if (ele.equals(".") || ele.equals("")) {
                continue;
            } else if (ele.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ele);
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : stack) { // Magical traversal
            sb.append("/");
            sb.append(s);
        }
    
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}