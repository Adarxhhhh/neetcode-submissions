class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;

        for(int weight : weights){
            min = Math.max(weight, min);
            max += weight;
        }

        if(days == 1)return max;

        int minCapacity = max;

        while(min <= max){
            int mid = min + (max - min)/2;

            int currDays = 0;
            int weightSum = 0;

            for(int weight : weights){
                int sum = weightSum + weight;
                if(sum == mid){
                    currDays++;
                    weightSum = 0;
                }else if(sum > mid){
                    currDays++;
                    weightSum = weight;
                }else{
                    weightSum = sum;
                }
            }

            if(weightSum > 0) currDays++;

            if(currDays <= days){
                max = mid - 1;
                minCapacity = Math.min(minCapacity, mid);
            }else{
                min = mid + 1;
            }
        }
    return minCapacity;
    }
}