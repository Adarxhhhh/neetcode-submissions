class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] arr1 = new int[26];
        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }

        int l = 0;
        int r = s1.length() - 1;
        int[] arr2 = new int[26];

        for (int i = 0; i < r; i++) {
            arr2[s2.charAt(i) - 'a']++;
        }

        while (r < s2.length()) {
            boolean isSame = true;
            arr2[s2.charAt(r) - 'a']++;

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                return true;
            } else {
                arr2[s2.charAt(l) - 'a']--;
                l++;
                r++;
            }
        }
        return false;
    }
}
