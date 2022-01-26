class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Boolean> used = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // important step
            graph.add(new ArrayList<>());
            used.add(false);
        }
        for (int[] i: edges) {
            int a = i[0];
            int b = i[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> qu = new LinkedList<>();
        qu.add(source);

        while (!qu.isEmpty()) {
            Integer u = qu.poll();
            for (Integer v: graph.get(u)) {
                if (!used.get(v)) {
                    qu.add(v);
                    used.set(v, true);
                }
            }
        }

        return used.get(destination);
    }

}
