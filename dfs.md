## LeetCode 1971 - Find if Path Exists in Graph - DFS

### DFS

```java
class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacency_list = new ArrayList<>();        
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);
        
        while (!stack.isEmpty()) {
            // Get the current node.
            int node = stack.pop();
            
            // Check if we have reached the target node.
            if (node == end) {
                return true;
            }
            
            // Check if we've already visited this node.
            if (seen[node]) {
                continue;
            }
            seen[node] = true;
            
            // Add all neighbors to the stack.
            for (int neighbor : adjacency_list.get(node)) {
                stack.push(neighbor);
            }
        }
        
        return false;
    }
}

```

### BFS

```java
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
```
