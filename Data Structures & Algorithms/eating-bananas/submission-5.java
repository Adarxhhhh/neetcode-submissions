class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long min = 1;
        long max = 0;

        for(int pile : piles){
            max = Math.max(pile, max);
        }
        
        long minSpeed = max;

        while(min <= max){
            long currSpeed = min + (max - min)/2;
            long currTime = 0;

            for(int pile : piles){
                currTime += (pile + currSpeed - 1)/currSpeed;
            }

            if(currTime <= h){
                minSpeed = Math.min(minSpeed, currSpeed);
                max = currSpeed - 1;
            }else{
                min = currSpeed + 1;
            }
        }
    return (int) minSpeed;
    }
}
