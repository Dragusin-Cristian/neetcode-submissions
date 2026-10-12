class Solution {
    public int search(int[] nums, int target) {
        
 
        int start = 0, end = nums.length -1;

        while (start <= end) {
            int m = start + (end - start)/2;

            if (target == nums[m]) {
                return m;
            }

            if (target < nums[m]) {
                end = m-1;
            }
            if (target > nums[m]) {
                start = m+1;
            }
        }

        return -1;

        // go to middle

        // check if target is lower/bigger, then slice the array and search there

        // 
    }
}
