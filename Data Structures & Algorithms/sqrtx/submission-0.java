class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x <= 3) return 1;

        long l = 0;
        long r = x/2;

        while(l <= r){
            long mid = l + (r - l)/2;
            long prod = mid * mid;

            if(prod == x){
                return (int)mid;
            }

            if(prod < x){
                l = mid + 1;
            }else if(prod > x){
                r = mid - 1;
            }
        }
    return (int)r;
    }
}