class Solution {
    int [] res;
    int idx;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        idx = numCourses - 1;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] req : prerequisites){
            graph.get(req[1]).add(req[0]);
        }

        int [] state = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(state[i] == 0 && hasCycle(i, graph, state)) return new int[] {};
        }

        return res;
    }

    public boolean hasCycle(int course, List<List<Integer>> graph, int [] state){
        state[course] = 1;

        for(int next : graph.get(course)){
            if(state[next] == 1) return true;
            if(state[next] == 0 && hasCycle(next, graph, state)) return true;
        }

        state[course] = 2;
        res[idx--] = course;
        return false;
    }
}
