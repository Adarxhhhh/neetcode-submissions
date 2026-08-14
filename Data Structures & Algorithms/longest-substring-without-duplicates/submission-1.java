class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;

        while(r < s.length()){
            char curr = s.charAt(r);

            while(l <= r && seen.contains(curr)){
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(curr);
            int currLen = r - l + 1;
            maxLen = Math.max(currLen, maxLen);
            r++;
        }
    return maxLen;
    }
}
