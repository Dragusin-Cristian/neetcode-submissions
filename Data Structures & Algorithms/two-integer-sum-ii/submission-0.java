class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> diffMap = new HashMap<>();

        // edge cases: empty array or array of 1 elem
        if (nums.length == 0) {
            return new int[0];
        }
        if (nums.length == 1 && nums[0]*2 == target) {
            return new int[0];
        }

        // compute the diffs
        for (int i = 0; i < nums.length; i++) {
            diffMap.put(target - nums[i], i);
        }

        // for each item in nums find the diff. add it to result and break;
        for (int i = 0; i < nums.length; i++) {
            // find the item in index where the key is the diff,
            if (diffMap.get(nums[i]) != null) {
                res[0] = i +1;
                res[1] = diffMap.get(nums[i]) +1;
                break;
            }
        }
        
        return res;
    }
}
