class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // edge case: empty array
        if (piles.length == 0) {
            return 0;
        }

        int k = 0;

        // find the biggest pile
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        // for 1 - biggestPile, find k with binary search
        int start = 1, end = max;
        while (start <= end) {
            int m = start + (end - start)/2;

            // validate k = m
            // if validates, save new k, and try a smaller amount
            // if invalidates, take a larger amount
            if (validateK(piles, h, m)) {
                k = m;
                end = m-1;
            } else {
                start = m+1;
            }
        }

        return k;
    }

    boolean validateK(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / k + (pile %k > 0 ? 1 : 0);
        }
        if (hours > h) {
            return false;
        }
        return true;
    }
}
