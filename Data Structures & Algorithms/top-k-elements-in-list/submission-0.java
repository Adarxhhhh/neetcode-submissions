class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> bucket = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int [] res = new int[k];
        int n = nums.length;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i <= nums.length; i++){
            bucket.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            bucket.get(value).add(key);
        }

        int idx = 0;

        for(int i = n; i>=0 && idx < k; i--){
            List<Integer> curr = bucket.get(i);

            for(int j = 0; j < curr.size() && idx < k; j++){
                res[idx++] = curr.get(j);
            }
        }

    return res;
    }
}
