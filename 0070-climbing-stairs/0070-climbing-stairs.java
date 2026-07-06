class Solution {
    public int rec(int n,int idx,int[]dp)
    {
        if(idx == n) return 1;
        if(idx>n) return 0;
        if(dp[idx]!=0) return dp[idx];
        dp[idx] = rec(n,idx+1,dp)+rec(n,idx+2,dp);
        return dp[idx];

    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return rec(n,0,dp);
    }
}