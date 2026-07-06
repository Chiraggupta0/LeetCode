class Solution {
    static int[] dp = new int[31];
    static 
    {
        Arrays.fill(dp,-1);
    }
    public int fib(int n) {
        // if(n<=1) return n;
        dp[0] = 0;
        dp[1] = 1;
        if(dp[n] != -1) return dp[n]; 
        for(int i=2;i<=n;i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}