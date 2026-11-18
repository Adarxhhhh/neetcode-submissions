class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxProf = 0;

        for(int i = 0; i < prices.length; i++){
            minVal = Math.min(minVal, prices[i]);
            int currProf = prices[i] - minVal;

            maxProf = Math.max(currProf, maxProf);
        }

    return maxProf;
    }
}
