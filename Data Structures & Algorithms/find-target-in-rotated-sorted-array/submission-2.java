class Solution {
    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return mySearch(0, nums.length -1);
    }

    int mySearch(int start, int end) {
        
        // edge case for 2 numbers in array
        if (end - start == 1) {
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            return -1;
        }

        int m = start + (end - start)/2;
        
        // if nums[start] <= nums[m] <= nums[end] 
        // => binary[start, end]
        if (nums[start] <= nums[m] && nums[m] <= nums[end]) {
            return binary(start, end);
        }

        // if nums[m] < nums[start] && nums[m] < nums[end]
        // & if target >= nums[m] && target <= nums[end] => binary[m, end]
        // & else => mySearch[start, m-1]
        if (nums[m] < nums[start] && nums[m] < nums[end]) {
            if (target >= nums[m] && target <= nums[end]) {
                return binary(m, end);
            }
            else {
                return mySearch(start, m-1);
            }
        }

        // if nums[m] > nums[start] && nums[m] > nums[end]
        // & if target > nums[start] && target < nums[m] => binary(start, m)
        // & else => mySearch(m+1, end)
        if (nums[m] > nums[start] && nums[m] > nums[end]) {
            if (target >= nums[start] && target <= nums[m]) {
                return binary(start, m);
            }
            else {
                return mySearch(m+1, end);
            }
        }

        return -1;
    }

    int binary(int start, int end) {
        int l = start, r = end;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (target == nums[m]) {
                return m;
            }
            else if (target > nums[m]) {
                l = m+1;
            }
            else {
                r = m-1;
            }
        }

        return -1;

    }
}
