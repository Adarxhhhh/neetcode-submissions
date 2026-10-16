class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int lMax = height[l];
        int rMax = height[r];
        int water = 0;

        while(l < r){
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if(height[l] < height[r]){
                water += lMax - height[l];
                l++;
            }else{
                water += rMax - height[r];
                r--;
            }
        }
    return water;
    }
}
