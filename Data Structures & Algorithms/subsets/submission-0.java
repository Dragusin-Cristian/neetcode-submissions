class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, subset, result);
        return result;
        
    }

    void backtrack(
        int[] nums, Integer i, List<Integer> subset, List<List<Integer>> result) 
    {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset)); // deep copy of subpath
            return;
        }

        // add elem

        subset.add(nums[i]);
        backtrack(nums, i +1, subset, result);

        // pop elem

        subset.remove(subset.size() -1);
        backtrack(nums, i +1, subset, result);
    }
}
