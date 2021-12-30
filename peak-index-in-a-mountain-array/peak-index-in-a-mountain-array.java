class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        
        while (l <= h) {
            int m = (h+l)/2;

            if (m > 0 && arr[m] > arr[m-1] && arr[m] > arr[m+1]) {
                return m;
            } else {
                if (arr[m+1] > arr[m]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return 0;
    }
}