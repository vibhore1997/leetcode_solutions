class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(heap.size() < k) {
                    heap.offer(matrix[i][j]);
                } else {
                    if (matrix[i][j] < heap.peek()) {
                        heap.poll();
                        heap.offer(matrix[i][j]);
                    }
                }
            }
        }
        return heap.peek();
    }
}