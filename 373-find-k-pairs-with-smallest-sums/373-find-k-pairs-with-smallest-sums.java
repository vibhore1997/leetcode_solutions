class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        // min heap
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        if (k == 0 || nums1.length == 0 || nums2.length == 0)
            return list;
        
        for (int i=0; i< Math.min(l2, k); i++) {
            queue.offer(new int[]{nums1[0], nums2[i], 0});
        }
        
        while (k-- > 0 && queue.isEmpty() == false) {
            int[] a = queue.poll();
            List<Integer> l = new ArrayList<>();
            l.add(a[0]);
            l.add(a[1]);
            list.add(l);
            
            int idx = a[2];
            
            if (idx < l1 - 1) {
                queue.offer(new int[]{nums1[idx+1], a[1], idx+1});
            }
        }
        return list;
    }
}