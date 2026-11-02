class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean [] visited = new boolean[nums.length];
        findPermutes(nums, visited, new ArrayList<>());
        return res;
    }

    public void findPermutes(int [] nums, boolean [] visited, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                list.add(nums[i]);
                visited[i] = true;
                findPermutes(nums, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
