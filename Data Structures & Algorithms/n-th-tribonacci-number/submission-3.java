class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n < 3) return 1;

        int [] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        return trib(dp, n);
    }

    public int trib(int [] dp, int idx){
        if(dp[idx] != -1){
            return dp[idx];
        }

        int val = trib(dp, idx - 1) + trib(dp, idx - 2) + trib(dp, idx - 3);
        dp[idx] = val;
        return val;
    }
}