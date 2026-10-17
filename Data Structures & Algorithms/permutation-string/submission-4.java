class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int l1 = s1.length();
        int l2 = s2.length();

        int [] s1Arr = new int [26];
        int [] arr = new int[26];

        for(int i = 0; i < l1; i++){
            s1Arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']++;
        }

        if(isSimilar(s1Arr, arr)) return true;

        int l = 0;

        for(int r = l1; r < l2; r++){

            arr[s2.charAt(l) - 'a']--;

            arr[s2.charAt(r) - 'a']++;

            if(isSimilar(s1Arr, arr)) return true;

            l++;
        }
    return false;
    }

    public boolean isSimilar(int [] arr1, int [] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

    return true;
    }
}
