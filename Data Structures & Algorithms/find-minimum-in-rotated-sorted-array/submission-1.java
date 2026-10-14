class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

     if (n == 1) {
        return nums[0];
     }

     return binarySearch(nums, 0, n-1);

    }

    int binarySearch(int[] nums, int start, int end) {

        if (end - start == 1) {
            return -Math.max(-nums[start], -nums[end]);
        }

        int m = start + (end - start)/2;

        // nums[start] <= nums[m] <= nums[end] => nums[start] is the min
        if (nums[start] <= nums[m] && nums[m] <= nums[end]) {
            return nums[start];
        }

        // nums[m] > nums[start] and nums[m] > nums[end] => 
        // => find min in nums[m +1, end] 
        if (nums[m] > nums[start] && nums[m] > nums[end]) {
            return binarySearch(nums, m+1, end);
        }

        // nums[m] < nums[start] and nums[m] < nums[end] =>
        // => find min in nums[start, m-1], and compare with nums[m]
        if (nums[m] < nums[start] && nums[m] < nums[end]) {
            int cand = binarySearch(nums, start, m-1);
            return -Math.max(-cand, -nums[m]);
        }

        return 10000;
    }
}
