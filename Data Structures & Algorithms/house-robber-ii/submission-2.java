class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int itr1 = helper(nums, 0, nums.length - 1);
        int itr2 = helper(nums, 1, nums.length);

        return Math.max(itr1, itr2);
    }

    public int helper(int [] nums, int start, int end){
        int [] dp = new int [nums.length];
        Arrays.fill(dp, -1);

        return findLoot(nums, dp, start, end);
    }

    public int findLoot(int [] nums, int [] dp, int idx, int end){
        if(idx >= end){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int loot = nums[idx] + findLoot(nums, dp, idx + 2, end);
        int skip = findLoot(nums, dp, idx + 1, end);

        dp[idx] = Math.max(loot, skip);
        return dp[idx];
    }
}
