class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int n = nums.length;
        int count = 0;
        seen.put(0, 1);
        int prefSum = 0;

        for(int num : nums){
            prefSum += num;

            if(seen.containsKey(prefSum - k)){
                count += seen.get(prefSum - k);
            }

            seen.put(prefSum, seen.getOrDefault(prefSum, 0) + 1);
        }
    return count;
    }
}