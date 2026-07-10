class Solution {
    // public int rec(int idx,int[] nums,int[]dp)
    // {
    //     if(idx >= nums.length) return 0;
    //     if(dp[idx]!=-1) return dp[idx];
    //     int pick = nums[idx]+rec(idx+2,nums,dp);
    //     int nonPick = rec(idx+1,nums,dp);
    //     return dp[idx] = Math.max(pick,nonPick);
    // }
    public int rob(int[] nums) {
        int[]dp = new int[nums.length+2];
        // Arrays.fill(dp,-1);
        int n = nums.length;
        dp[n] = 0;
        dp[n+1] = 0;
        for(int i=n-1;i>=0;i--)
        {
            int pick = nums[i]+dp[i+2];
            int nonPick = dp[i+1];
            dp[i] = Math.max(pick,nonPick);
        }
        return dp[0];
    }
}