class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int [] res = new int[nums.length];
        Arrays.fill(res, 1);
        int prod = 1;

        for(int i = 0; i < res.length; i++){
            res[i] *= prod;
            prod *= nums[i];
        }

        prod = 1;

        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= prod;
            prod *= nums[i];
        }

    return res;
    }
}  
