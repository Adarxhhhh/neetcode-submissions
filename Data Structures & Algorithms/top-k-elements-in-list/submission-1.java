class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<List<Integer>> topK = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            topK.add(new ArrayList<>());
        }

        for(int num : map.keySet()){
            topK.get(map.get(num)).add(num);
        }

        int [] res = new int[k];
        int idx = k - 1;

        for(int i = topK.size() - 1; i >= 0 && idx >= 0; i--){
            List<Integer> curr = topK.get(i);

            for(int j = curr.size() - 1; j >= 0 && idx >= 0; j--){
                res[idx--] = curr.get(j);
            }
        }

    return res;
    }
}
