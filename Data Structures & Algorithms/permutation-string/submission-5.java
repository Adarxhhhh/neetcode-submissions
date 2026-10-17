class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int l1 = s1.length();
        int l2 = s2.length();

        int [] arr1 = new int [26];
        int [] arr2 = new int [26];

        for(int i = 0; i < l1; i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if(isSimilar(arr1, arr2)) return true;

        int l = 0;
        for(int r = l1; r < l2; r++){
            arr2[s2.charAt(l) - 'a']--;
            arr2[s2.charAt(r) - 'a']++;

            if(isSimilar(arr1, arr2)) return true;
            l++;
        }

    return false;
    }

    public boolean isSimilar(int [] arr1, int [] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
    return true;
    }
}
