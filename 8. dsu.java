// https://leetcode.com/problems/find-all-people-with-secret/

class Solution {
    static class UnionFind {
        static int[] parent;
        static int[] rank;
        
        UnionFind (int n) {
            parent = new int[n];
            rank = new int[n];
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        private static int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        
        private static boolean unite(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
 
            if (rank[rootX] >= rank[rootY]) {
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }else {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
 
            return true;
        }
        
        private static void reset(int x) {
            parent[x] = x;
            rank[x] = 1;
        }
    }
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
            
        UnionFind uf = new UnionFind(n);
        
        uf.unite(0, firstPerson);
        
        int m = meetings.length;
        for (int i = 0; i < m;) {
            List<Integer> peoples = new ArrayList<>();
            
            int time = meetings[i][2];
            while (i < m && meetings[i][2] == time) {
                uf.unite(meetings[i][0], meetings[i][1]);
                peoples.add(meetings[i][0]);
                peoples.add(meetings[i][1]);
                
                i++;
            }
            
            for (int people : peoples) {
                if (uf.find(people) != uf.find(0)) {
                    uf.reset(people);
                }
            }
        }
        
        List<Integer> sharedSecret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == uf.find(0)) {
                sharedSecret.add(i);
            }
        }
        
        return sharedSecret;
    }
}

