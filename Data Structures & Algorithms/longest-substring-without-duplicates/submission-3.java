class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int maxLen = 0;

        while(r < s.length()){
            char curr = s.charAt(r);

            while(l < r && set.contains(curr)){
                set.remove(s.charAt(l));
                l++;
            }

            int currLen = r - l + 1;
            set.add(curr);
            maxLen = Math.max(currLen, maxLen);
            r++;
        }
    return maxLen;
    }
}
