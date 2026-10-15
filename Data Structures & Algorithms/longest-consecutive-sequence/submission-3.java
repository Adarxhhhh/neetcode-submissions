class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> dict = new HashSet<>();

        for(int num : nums){
            dict.add(num);
        }

        int maxLen = 0;

        for(int num : nums){
            int currLen = 0;
            if(!dict.contains(num - 1)){
                while(dict.contains(num)){
                    currLen++;
                    num++;
                }
            }

            maxLen = Math.max(currLen, maxLen);
        }
    return maxLen;
    }
}
