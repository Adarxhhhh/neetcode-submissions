class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int l = 0;
        int r = s1.length() - 1;
        int [] arr1 = new int[26];

        for(char c : s1.toCharArray()){
            arr1[c - 'a']++;
        }

        while(r < s2.length()){
            if(compare(arr1, s2.substring(l, r + 1))){
                return true;
            }
            l++;
            r++;
        }
        return false;
    }

    public boolean compare(int [] arr1, String s2){
        int [] arr2 = new int [26];

        for(char c : s2.toCharArray()){
            arr2[c - 'a']++;
        }

        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
    return true;
    }
}
