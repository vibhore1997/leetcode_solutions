class Solution {
    Map<Long, Double> hmap = new HashMap<>();
    public double myPow(double x, int n) {
        long m = n;
        if (Double.compare(x, 0.0) == 0) {
            return 0.0;
        }
        double ans = helper(x, Math.abs(m));
        if (m >= 0) {
            return ans;
        } else {
            return 1.0/ans;
        }
    }
    
    public double helper(double x, long n) {
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        }
        
        if (hmap.containsKey(n)) {
            return hmap.get(n);
        }
        
        if (n % 2 == 0) {
            hmap.put(n, helper(x, (long)n/2) * helper(x, (long)n/2));
            return hmap.get(n);
        } else {
            hmap.put(n, helper(x, (long)n/2) * helper(x, (long)(n/2 + 1)));
            return hmap.get(n);
        }
    }
}