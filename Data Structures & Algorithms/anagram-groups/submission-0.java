class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String ref = new String(arr);

            if(map.containsKey(ref)){
                map.get(ref).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(ref, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> list : map.values()){
            res.add(list);
        }

        return res;
    }
}
