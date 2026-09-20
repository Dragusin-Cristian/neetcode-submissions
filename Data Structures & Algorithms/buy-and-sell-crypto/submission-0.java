class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (Integer num : prices) {
            // check for new min price
            if (num < minPrice) minPrice = num;

            // check for maxProfit
            Integer diff = num - minPrice;
            if (diff > maxProfit) maxProfit = diff;
        }

        return maxProfit;
    }
}
