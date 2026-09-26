class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> trustList = new HashMap<>();
        Set<Integer> trusters = new HashSet<>();

        for(int [] t : trust){
            if(trustList.containsKey(t[1])){
                trustList.get(t[1]).add(t[0]);
            }else{
                List<Integer> trustL = new ArrayList<>();
                trustL.add(t[0]);
                trustList.put(t[1], trustL);
            }

            trusters.add(t[0]);
        }

        for(int key : trustList.keySet()){
            List<Integer> trustL = trustList.get(key);

            if(trustL.size() == n - 1){
                int idx = 0;

                while(idx < trustL.size() && trustL.get(idx) != key){
                    idx++;
                }

                if(idx == n - 1 && !trusters.contains(key)){
                    return key;
                }
            } 
        }
    return -1;
    }
}