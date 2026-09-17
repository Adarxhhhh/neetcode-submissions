class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int [] rank = new int[26];

        for(int i = 0 ; i < order.length(); i++){
            rank[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++){
            if(!isOrdered(words[i], words[i + 1], rank)){
                return false;
            }
        }
    return true;
    }

    public boolean isOrdered(String s1, String s2, int [] rank){
        int l1 = s1.length();
        int l2 = s2.length();

        int minLen = Math.min(l1, l2);

        for(int i = 0; i < minLen; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(c1 != c2){
                return rank[c1 - 'a'] < rank[c2 - 'a'];
            }
        }

        return l1 <= l2;
    }
}