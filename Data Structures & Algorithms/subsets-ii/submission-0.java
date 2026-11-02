class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        findSubsets(nums, new ArrayList<>(), 0);

        return res;    
    }

    public void findSubsets(int [] nums, List<Integer> list, int idx){
        res.add(new ArrayList<>(list));

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]){
                continue;
            }

            list.add(nums[i]);
            findSubsets(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
