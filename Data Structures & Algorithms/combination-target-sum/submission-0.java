class Solution {
    int target;
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        this.backtrack(0, result, path);

        return result;
    }

    void backtrack(int i, List<List<Integer>> result, List<Integer> path){
        for (int j = i; j < this.nums.length; j++) {
            // add
            path.add(this.nums[j]);

            // if sum < target => backtrack
            if (this.sum(path) < this.target) {
                this.backtrack(j, result, path);
            // if sum == target => add to result
            } else if (this.sum(path) == this.target) {
                result.add(new ArrayList<>(path));
            }
            // if sum > target => do nothing

            // pop in any case
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
