class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2) return s;

        String res = "";

        for(int i = 0; i < n - 1; i++){
            String str1 = findString(s, i, i);
            String str2 = findString(s, i, i + 1);

            if(str1.length() > res.length()){
                res = str1;
            }

            if(str2.length () > res.length()){
                res = str2;
            }
        }
    return res;
    }

    public String findString(String s, int i, int j){
        while(i >= 0 && j < s.length()){
            if(s.charAt(i) != s.charAt(j)){
                break;
            }else{
                i--;
                j++;
            }
        }
        return s.substring(i + 1, j);
    }
}
