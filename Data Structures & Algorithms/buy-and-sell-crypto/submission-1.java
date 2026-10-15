class Solution {
    public int maxProfit(int[] prices) {

        int diffCand = 0, lowest = prices[0];

        for (Integer price : prices) {
            if (price > lowest) {
                diffCand = Math.max(diffCand, price - lowest);
            } else {
                lowest = price;
            }
        }

        return diffCand;
        
    }
}
