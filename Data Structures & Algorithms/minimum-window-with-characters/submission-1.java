class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();

        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int required = tMap.size();
        int formed = 0;
        int l = 0;
        int r = 0;
        int [] ans = {-1, 0, 0};
        Map<Character, Integer> windowChars = new HashMap<>();

        while(r < s.length()){
            char curr = s.charAt(r);
            windowChars.put(curr, windowChars.getOrDefault(curr, 0) + 1);

            if(tMap.containsKey(curr) && tMap.get(curr).intValue() == windowChars.get(curr).intValue()){
                formed++;
            }

            while(l <= r && formed == required){
                char left = s.charAt(l);

                if(ans[0] == -1 || ans[0] > r - l + 1){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowChars.put(left, windowChars.get(left) - 1);
                if(tMap.containsKey(left) && tMap.get(left).intValue() > windowChars.get(left).intValue()){
                    formed--;
                }

            l++;
            }
        r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
