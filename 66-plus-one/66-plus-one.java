class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
        }
        
        if (carry == 1) {
            int[] arr = new int[digits.length + 1];
            arr[0] = carry;
            for(int i=0; i<digits.length; i++) {
                arr[i+1] = digits[i];
            }
            return arr;
        }
        return digits;
    }
}