// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         Queue<Integer> heap = new PriorityQueue<>((a,b) -> b - a); Max heap, brute
        
//         for(int i=0; i<matrix.length; i++) {
//             for(int j=0; j<matrix[0].length; j++) {
//                 if(heap.size() < k) {
//                     heap.offer(matrix[i][j]);
//                 } else {
//                     if (matrix[i][j] < heap.peek()) {
//                         heap.poll();
//                         heap.offer(matrix[i][j]);
//                     }
//                 }
//             }
//         }
//         return heap.peek();
//     }
// }

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]); // Min heap, like K sorted lists
        
        for(int i=0; i<Math.min(matrix.length, k); i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }
        int ans = 0;
        
        while(k > 0) {
            int[] minEle = heap.poll();
            ans = minEle[0];
            if (minEle[2] + 1 < matrix[0].length) {
                int r = minEle[1];
                int c = minEle[2] + 1;
                heap.offer(new int[]{matrix[r][c], r, c});
            }
            k--;
        }
        return ans;
    }
}