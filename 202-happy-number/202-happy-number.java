class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        
        while (true) {
            if (n == 1) {
                return true;
            }
            if (hs.add(n) == false) {
                return false;
            }
            
            int sum = 0;
            while (n != 0) {
                int dig = n % 10;
                sum += dig*dig;
                n = n / 10;
            }
            n = sum;
        }

    }
}