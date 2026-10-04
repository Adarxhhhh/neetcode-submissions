class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        itr1 = self.helper(nums, 0, len(nums) - 1)
        itr2 = self.helper(nums, 1, len(nums))

        return max(itr1, itr2)

    def helper(self, nums: List[int], start: int, end: int) -> int:
        n = len(nums)
        dp = [-1] * n

        return self.findLoot(nums, dp, start, end)
    
    def findLoot(self, nums: List[int], dp: List[int], idx: int, end: int) -> int:

        if idx >= end:
            return 0

        if dp[idx] != -1:
            return dp[idx]

        loot = nums[idx] + self.findLoot(nums, dp, idx + 2, end)
        skip = self.findLoot(nums, dp, idx + 1, end);

        dp[idx] = max(loot, skip)
        return dp[idx]
