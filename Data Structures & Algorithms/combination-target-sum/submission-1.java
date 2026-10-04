class Solution {
    int target;
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
       this.target = target;
       this.nums = nums;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(0, result, path);

        return result;
    }

    void backtrack(int i, List<List<Integer>> result, List<Integer> path){
       for (int j = i; j < nums.length; j++) {
            // add
            path.add(nums[j]);

            // if (sum(path) < target) => backtrack(j)
            if (sum(path) < target) {
                backtrack(j, result, path);
            }

            // if sum(path) == target => add to result
            if (sum(path) == target) {
                result.add(new ArrayList<>(path));
            }

            // pop from path
            path.remove(path.size() -1);
       }
    }

    int sum(List<Integer> ls) {
        int sum = 0;
        for (int n : ls) {
            sum += n;
        }
        return sum;
    }
}
