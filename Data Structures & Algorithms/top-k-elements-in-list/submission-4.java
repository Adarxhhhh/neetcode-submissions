class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(num));
        }

        for(int i = 0; i <= maxFreq; i++){
            buckets.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            buckets.get(val).add(key);
        }

        int [] res = new int[k];
        int idx = 0;

        for(int i = buckets.size() - 1; i >= 0 && idx < k; i--){
            List<Integer> curr = buckets.get(i);
            for(int j = 0; j < curr.size() && idx < k; j++){
                res[idx++] = curr.get(j);
            }
        }

        return res;
    }
}
