class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [-1] * (n + 1)

        return self.findMinCost(cost, dp, n)

    def findMinCost(self, cost: List[int], dp: List[int], idx: int) -> int:
        if idx <= 1:
            return 0;

        if dp[idx] != -1:
            return dp[idx]

        one_prev_cost = cost[idx - 1] + self.findMinCost(cost, dp, idx - 1)
        two_prev_cost = cost[idx - 2] + self.findMinCost(cost, dp, idx - 2)

        dp[idx] = min(one_prev_cost, two_prev_cost)
    
        return dp[idx]
