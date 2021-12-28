/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 9999;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            if (reader.get(mid) == Integer.MAX_VALUE) {
                high = mid - 1;
                continue;
            }
            
            if (reader.get(mid) < target) {
                low = mid + 1;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else if (reader.get(mid) == target) {
                return mid;
            }
        }
        return -1;
    }
}