class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return findLoot(nums, dp, 0);
    }

    public int findLoot(int [] nums, int [] dp, int idx){
        if(idx >= nums.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int rob = nums[idx] + findLoot(nums, dp, idx + 2);
        int skip = findLoot(nums, dp, idx + 1);

        dp[idx] = Math.max(rob, skip);
        return dp[idx];
    }
}
