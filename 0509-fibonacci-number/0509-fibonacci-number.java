class Solution {
    static int[] dp = new int[31];
    static 
    {
        Arrays.fill(dp,-1);
    }
    public int fib(int n) {
        if(n<=1) return dp[n] = n;
        if(dp[n] != -1) return dp[n]; 
        return dp[n] = fib(n-1)+fib(n-2);
    }
}