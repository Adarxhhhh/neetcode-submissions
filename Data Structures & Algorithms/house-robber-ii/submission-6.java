class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int n = nums.length;
        int [] dp1 = new int[n];
        int [] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(findLoot(nums, dp1, 0, n - 1), findLoot(nums, dp2, 1, n));
    }

    public int findLoot(int [] nums, int [] dp, int idx, int end){
        if(idx >= end){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int rob = nums[idx] + findLoot(nums, dp, idx + 2, end);
        int skip = findLoot(nums, dp, idx + 1, end);

        dp[idx] = Math.max(rob, skip);
        return dp[idx];
    }
}
