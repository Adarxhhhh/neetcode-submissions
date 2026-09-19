class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] req : prerequisites){
            graph.get(req[1]).add(req[0]);
        }

        int [] state = new int[numCourses];

        for(int course = 0; course < numCourses; course++){
            if(state[course] == 0 && hasCycle(course, graph, state)) return false;
        }

        return true;
    }

    public boolean hasCycle(int course, List<List<Integer>> graph, int [] state){
        state[course] = 1;

        for(int next : graph.get(course)){
            if(state[next] == 1) return true;
            if(state[next] == 0 && hasCycle(next, graph, state)) return true;
        }

        state[course] = 2;
        return false;
    }
}
