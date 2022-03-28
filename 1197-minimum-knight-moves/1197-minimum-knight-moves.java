class Solution {
    public int minKnightMoves(int x, int y) {
        int dx[] = {2,2,-2,-2,1,-1,1,-1};
        int dy[] = {1,-1,1,-1,2,2,-2,-2};
        
//         class Point {
//             int a;
//             int b;
            
//             public Point(int a, int b) {
//                 this.a = a;
//                 this.b = b;
//             }
            
//             @Override
//             public boolean equals(Object o) {
//                 Point p = (Point)o;
//                 return this.a == p.a && this.b == p.b;
//             }
            
//             @Override
//             public int hashCode() {
//                 return Objects.hash(a,b);
//             }
//         }
        int vis[][] = new int[610][610];
        Queue<int[]> queue = new LinkedList<>();
        vis[0][0] = 1;
        queue.offer(new int[]{0,0});
        int level = 0;
        
//         Point p1 = new Point(1,0);
//         Point p2 = new Point(1,1);
        // System.out.println(hs.contains(new Point(0,0)));
        
        
        while (queue.size() > 0) {
            int size = queue.size();
            
            while(size-- > 0) {
                int[] coord = queue.poll();
                int x1 = coord[0], y1 = coord[1];
                // System.out.println("x = " + x1 + " y = " + y1);
                
                if (x1 == x && y1 == y) return level;
                
                for (int i=0; i<8; i++) {
                    int x2 = x1 + dx[i];
                    int y2 = y1 + dy[i];
                    
                    // if (x2 == x && y2 == y) return level + 1;
                    
                    
                    if (vis[x2 + 303][y2 + 303] != 1) {
                        vis[x2 + 303][y2 + 303] = 1;
                        queue.offer(new int[]{x2,y2});
                    }
                    
                }
            }
            level++;
        }
        return 0;
    }
}