class Solution {
    public int rec(int idx,int[] nums,int[]dp)
    {
        if(idx >= nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick = nums[idx]+rec(idx+2,nums,dp);
        int nonPick = rec(idx+1,nums,dp);
        return dp[idx] = Math.max(pick,nonPick);
    }
    public int rob(int[] nums) {
        int[]dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return rec(0,nums,dp);
    }
}