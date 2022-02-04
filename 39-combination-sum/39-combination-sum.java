class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(candidates, res, target, 0, new ArrayList<>(), 0);
        return res;
    }
    
    void backtrack(int[] arr, List<List<Integer>> res, int target, int sum, List<Integer> list, int pos) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=pos; i<arr.length; i++) {
            sum += arr[i];
            if (sum > target) {
                break;
            }
            list.add(arr[i]);
            
            backtrack(arr, res, target, sum, list, i);
            
            sum -= arr[i];
            list.remove(list.size() - 1);
        }
    }
}