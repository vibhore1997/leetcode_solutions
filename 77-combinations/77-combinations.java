class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[n];
        track(ans, n , k, used, new ArrayList<Integer>(), 1);
        return ans;
    }
    
    private void track(List<List<Integer>> ans, int n, int k, boolean[] used, List<Integer> list, int j) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=j; i<=n; i++) {
                
                list.add(i);
            
                track(ans, n, k, used, list, i+1);
            
                list.remove(list.size() - 1);
        }
    }
}