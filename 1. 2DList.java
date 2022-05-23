// https://leetcode.com/problems/interleaving-string/

class Solution {
    public String s, t, result;
    public Integer m, n, o;
    public ArrayList<ArrayList<Integer>> memo;

    public int dp(int i, int j, int k) {
        if (i >= m && j >= n && k >= o) return 1;
        if (k >= o) return 0;

        Integer ans = memo.get(i).get(j);
        if (ans == -1) {
            ans = 0;
            if (i < m && s.charAt(i) == result.charAt(k)) {
                ans += dp(i + 1, j, k + 1);
                ans = (ans == 0) ? 0 : 1;
            }
            if (j < n && t.charAt(j) == result.charAt(k)) {
                ans += dp(i, j + 1, k + 1);
                ans = (ans == 0) ? 0 : 1;
            }
        }
        
        memo.get(i).set(j, ans);
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s = s1;
        this.t = s2;
        this.result = s3;
        this.m = s1.length();
        this.n = s2.length();
        this.o = s3.length();
        
        memo = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < 101; i++) 
            memo.add(new ArrayList<Integer>());
        
        for (int i = 0; i < 101; i++) 
            for (int j = 0; j < 101; j ++) 
                memo.get(i).add(-1);
            
        return dp(0, 0, 0) == 1;
    }
}
