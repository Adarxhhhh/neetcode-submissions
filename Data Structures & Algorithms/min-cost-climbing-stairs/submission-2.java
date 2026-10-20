class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n];
        
        return Math.min(findMinCost(cost, dp, n - 1), findMinCost(cost, dp, n - 2));
    }

    public int findMinCost(int [] cost, int [] dp, int idx){
        if(idx == 0) return cost[0];
        if(idx == 1) return cost[1];

        if(dp[idx] != 0) return dp[idx];

        dp[idx] = cost[idx] + Math.min(findMinCost(cost, dp, idx - 1), findMinCost(cost, dp, idx - 2));
        return dp[idx];
    }
}
