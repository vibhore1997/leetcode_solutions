class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        
         // int arr[] = {1,2,3,4,5,6,7,8,9}; can be done without this space
        
        backtrack(res, k, n, 0, 0, new ArrayList<>());
        return res;
    }
    
    void backtrack( List<List<Integer>> res, int k, int target, int pos, int sum, List<Integer> list) {
        if (sum > target) {
            return;
        }
        if (list.size() == k) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        
        for(int i = pos; i < 9; i++) {
            sum += i+1;
            if (sum > target) {
                break;
            }
            list.add(i+1);
            
            backtrack(res, k, target, i + 1, sum, list);
            
            sum -= i+1;
            list.remove(list.size() - 1);
        }
    }
}