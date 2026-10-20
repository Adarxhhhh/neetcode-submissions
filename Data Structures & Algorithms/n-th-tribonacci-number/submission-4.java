class Solution {
    public int tribonacci(int n) {
        int [] dp = new int[n + 1];
        
        return findTrib(dp, n);
    }

    public int findTrib(int [] dp, int idx){
        if(idx == 0) return 0;
        if(idx == 1) return 1;
        if(idx == 2) return 1;

        if(dp[idx] != 0) return dp[idx];
        dp[idx] = findTrib(dp, idx - 1) + findTrib(dp, idx - 2) + findTrib(dp, idx - 3);
        return dp[idx];
    }
}