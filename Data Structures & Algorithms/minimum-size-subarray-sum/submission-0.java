class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while(r < nums.length){
            sum += nums[r];
            int currLen = 0;

            if(sum >= target){
                currLen = r - l + 1;

                while(l <= r && sum >= target){
                    sum -= nums[l];

                    currLen = r - l + 1;
                    l++;
                }

                minLen = Math.min(minLen, currLen);
            }

            r++;
        }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}