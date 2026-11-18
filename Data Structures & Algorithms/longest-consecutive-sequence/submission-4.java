class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            seen.add(num);
        }

        int maxLen = 0;

        for(int num : nums){
            int currLen = 1;
            int currNum = num;
            if(!seen.contains(num - 1)){
                while(seen.contains(currNum + 1)){
                    currLen++;
                    currNum++;
                }
            }
            
            maxLen = Math.max(currLen, maxLen);
        }

    return maxLen;
    }
}
