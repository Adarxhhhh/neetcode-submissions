class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for (int pile : piles) {
            r = Math.max(pile, r);
        }

        int minSpeed = r;

        while(l <= r){
            int currSpeed = l + (r - l)/2;
            int currTime = 0;

            for(int pile : piles){
                currTime += (pile + currSpeed - 1)/currSpeed;
            }

            if(currTime <= h){
                r = currSpeed - 1;
                minSpeed = Math.min(minSpeed, currSpeed);
            }else{
                l = currSpeed + 1;
            }
        }
    return minSpeed;
    }
}
