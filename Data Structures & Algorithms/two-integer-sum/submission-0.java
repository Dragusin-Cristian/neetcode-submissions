class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffSet = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            Integer diff = target - num;
            if (diffSet.get(diff) != null) {
                return new int[]{diffSet.get(diff), i};
            } else {
                diffSet.put(num, i);
            }
        }
        return new int[0];
    }
}
