class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n];

        Arrays.fill(dp, - 1);

        return Math.min(findMinCost(cost, dp, n - 1), findMinCost(cost, dp, n - 2));
    }

    public int findMinCost(int [] cost, int [] dp, int idx){
        if(idx == 0 || idx == 1){
            return cost[idx];
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int minCost = cost[idx] + Math.min(findMinCost(cost, dp, idx - 1), findMinCost(cost, dp, idx - 2));
        dp[idx] = minCost;
        return minCost;
    }
}
