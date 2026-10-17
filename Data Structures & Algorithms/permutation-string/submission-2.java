class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int l = 0;
        int r = s1.length() - 1;

        while(r < s2.length()){
            String subStr = s2.substring(l, r + 1);

            if(isPerm(s1, subStr)) return true;
            r++;
            l++;
        }

    return false;
    }

    public boolean isPerm(String str1, String str2){
        char [] arr1 = str1.toCharArray();
        char [] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String s1 = new String(arr1);
        String s2 = new String(arr2);

        if(s1.equals(s2)) return true;
        return false;
    }
}
