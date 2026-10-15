class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            if(isSimilar(s, l, r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
    return true;
    }

    public boolean isSimilar(String s, int l, int r){
        if(s.charAt(l) == s.charAt(r)){
            return true;
        }else{
            return false;
        }
    }
}
