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

            set.add(curr);
            int currLen = r - l + 1;
            maxLen = Math.max(maxLen, currLen);
            r++;
        }

    return maxLen;
    }
}
