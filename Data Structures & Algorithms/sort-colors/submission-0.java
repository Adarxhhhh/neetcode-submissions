class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0;
        int m = 0;
        int r = n - 1;

        while(m <= r){
            if(nums[m] == 0){
                swap(nums, l, m);
                l++;
                m++;
            }else if(nums[m] == 2){
                swap(nums, m, r);
                r--;
            }else{
                m++;
            }
        }
    }

    public void swap(int [] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}