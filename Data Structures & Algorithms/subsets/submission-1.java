class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        this.backtrack(nums, 0,  result, path);

        return result;
        
    }


    void backtrack(
        int[] nums, int i, List<List<Integer>> result, List<Integer> path) 
    {
        // if is a leaf return
        if (i >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // decide to add
        path.add(nums[i]);
        backtrack(nums, i+1, result, path);

        // decide not to add
        path.remove(path.size() -1);
        backtrack(nums, i+1, result, path);
    }

   
}
