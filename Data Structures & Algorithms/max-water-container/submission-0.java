class Solution {
    public int maxArea(int[] nums) {
        int max = 0, l = 0, r = nums.length -1;

        while (l < r) {
            int min = Math.min(nums[l], nums[r]);
            int dist = r - l;
            max = Math.max(dist * min, max);
            if (nums[r] < nums[l]) {
                r --;
            } else {
                l ++;
            }
        }

        return max;
    }
}
