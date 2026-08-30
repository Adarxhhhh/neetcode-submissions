class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> uniqueElements = new HashSet<>();
        int maxLen = 1;

        for(int num : nums){
            uniqueElements.add(num);
        }

        for(int num : nums){
            int currLen = 0;
            int curr = num;

            if(!uniqueElements.contains(curr - 1)){
                while(uniqueElements.contains(curr)){
                    curr++;
                    currLen++;
                }
            }

            maxLen = Math.max(currLen, maxLen);
        }

    return maxLen;
    }
}
