class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;

        Set<Character> windowChars = new HashSet<>();
        int maxLen = 0;
        
        while(r < s.length()){
            char curr = s.charAt(r);

            while(l <= r && windowChars.contains(curr)){
                windowChars.remove(s.charAt(l));
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            windowChars.add(curr);
            r++;
        }

    return maxLen;
    }
}
