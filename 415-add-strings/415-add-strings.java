class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (p1 >= 0 || p2 >= 0) {
            int x = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int y = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            
            int sum = x + y + carry;
            
            carry = sum / 10;
            int res = sum % 10;
            
            sb.append(res);
            
            p1--;
            p2--;
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}