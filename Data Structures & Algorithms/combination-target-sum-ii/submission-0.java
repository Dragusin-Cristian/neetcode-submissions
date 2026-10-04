class Solution {
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;

        // edge case: nums length is 1

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // sort nums
        int[] nums = Arrays.stream(candidates).sorted().toArray();

        this.backtrack(0, nums, result, path);

        return result;
    }

    void backtrack(
        int i, int[] nums, List<List<Integer>> result, List<Integer> path) 
    {
        
        for (int j =i; j < nums.length; j++) {
            // if j > 0 && nums[j] == nums[j-1] => continue;
            if (j > i && nums[j] == nums[j-1]) {
                continue;
            }

            // add to path
            path.add(nums[j]);

            // if sum(path) < target => backtrack(j+1)
            if (this.sum(path) < target) {
                this.backtrack(j +1, nums, result, path);
            }

            // if sum(path) == target => add to result
            if (this.sum(path) == target) {
                result.add(new ArrayList<>(path));
            }

            // pop from path
            path.remove(path.size() -1);
        }


    }

    int sum(List<Integer> path) {
        int sum = 0;
        for (Integer x : path) {
            sum += x;
        }
        return sum;
    }
}
