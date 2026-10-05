class Solution {
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = Arrays.stream(nums).sorted().toArray();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        result.add(new ArrayList<>(path));
        backtrack(0, result, path);

        return result;
    }

    void backtrack(int i, List<List<Integer>> result, List<Integer> path){
        for (int j = i; j < nums.length; j++) {
            // skip if j>i && nums[j] == nums[j-1] (skip duplicates)
            if (j>i && nums[j] == nums[j-1]) {
                continue;
            }

            // add to path
            path.add(nums[j]);

            // add path to result
            result.add(new ArrayList<>(path));

            // backtrack(j+1) (skip repeating same element position)
            backtrack(j +1, result, path);

            // pop from path
            path.remove(path.size() -1);
        }
    }
}
