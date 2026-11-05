class Solution {
    public int majorityElement(int[] nums) {
        int maxEle = 0;
        int maxFreq = 0;

        for(int i = 0; i < nums.length; i++){
            if(maxFreq == 0){
                maxEle = nums[i];
                maxFreq++;
            }else if(nums[i] != maxEle){
                maxFreq--;
            }else{
                maxFreq++;
            }
        }

    return maxEle;
    }
}