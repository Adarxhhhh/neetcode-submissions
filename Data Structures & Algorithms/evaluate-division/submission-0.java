class Solution {
    class Edge {
        String target;
        double weight;

        public Edge(String target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();

        int size = equations.size();

        for (int i = 0; i < size; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Edge(v, val));
            graph.get(v).add(new Edge(u, 1.0 / val));
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest))
                results[i] = -1.0;
            else if (src.equals(dest))
                results[i] = 1.0;
            else {
                Set<String> visited = new HashSet<>();
                results [i] = dfs(src, dest, graph, 1.0, visited);
            }
        }
        return results;
    }

    public double dfs(String curr, String target, Map<String, List<Edge>> graph, double accProd,
        Set<String> visited) {
        visited.add(curr);

        if (curr.equals(target))
            return accProd;

        for (Edge next : graph.get(curr)) {
            if (!visited.contains(next.target)) {
                double res = dfs(next.target, target, graph, accProd * next.weight, visited);

                if (res != -1.0) {
                    return res;
                }
            }
        }
        return -1.0;
    }
}