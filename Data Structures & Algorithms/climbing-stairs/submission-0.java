class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        return findWays(dp, n);
    }

    public int findWays(int [] dp, int idx){
        if(idx <= 1){
            return 1;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int curr = findWays(dp, idx - 1) + findWays(dp, idx - 2);
        dp[idx] = curr;

    return curr;
    }
}
