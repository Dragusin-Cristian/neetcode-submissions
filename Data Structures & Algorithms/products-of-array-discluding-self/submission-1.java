class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] productsL = new int[n];
        int[] productsR = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                productsL[i] = nums[i];
            } else {
                productsL[i] = productsL[i-1] * nums[i];
            }
        } 

        for (int i = n-1; i >=0; i--) {
            if (i == n-1) {
                productsR[i] = nums[i];
            } else {
                productsR[i] = productsR[i+1] * nums[i];
            }
        }

        res[0] = productsR[1];
        res[n-1] = productsL[n-2];
        for (int i = 1; i < n-1; i++) {
            res[i] = productsL[i-1] * productsR[i+1];
        }
        return res;
    }
}  
