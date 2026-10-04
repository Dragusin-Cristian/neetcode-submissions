class Solution {
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;

        Set<Integer> path = new LinkedHashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, result, path);

        return result;
    }

    void backtrack(int i, List<List<Integer>> result, Set<Integer> path) {
        for (int j = 0; j < nums.length; j++) {
            // if path contains nums[j] => continue;
            if (path.contains(nums[j])) {
                continue;
            }

            // add nums[j] to path
            path.add(nums[j]);

            // if path.length < nums.length => backtrack(j+1)
            if (path.size() < nums.length) {
                backtrack(j +1, result, path);
            }

            // if path.length == nums.length => add path to result
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
            }

            // pop from path
            path.remove(nums[j]);
        }
    }
}
