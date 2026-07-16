class Solution {
    int profit = 0;
    public int rec(int[] prices,int idx,int flag,int[][] dp)
    {
        if(idx == prices.length) return 0;
        if(dp[idx][flag] != -1) return dp[idx][flag];
        if(flag == 1)
        {
            int take = 0-prices[idx]+rec(prices,idx+1,0,dp);
            int nonTake = rec(prices,idx+1,1,dp);
            dp[idx][flag] = Math.max(take,nonTake);
        }
        else
        {
            int t = prices[idx]+rec(prices,idx+1,1,dp);
            int nt = rec(prices,idx+1,0,dp);
            dp[idx][flag] = Math.max(t,nt);
        }
        return dp[idx][flag];
    }
    public int maxProfit(int[] prices) {
        int[][]dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return rec(prices,0,1,dp);
    }
}