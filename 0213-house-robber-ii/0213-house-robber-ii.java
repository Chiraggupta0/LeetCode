class Solution {
    public int rec(int[] nums,int idx,int end,int[] dp)
    {
        if(idx > end) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick = nums[idx]+rec(nums,idx+2,end,dp);
        int nonPick = rec(nums,idx+1,end,dp);
        return dp[idx] = Math.max(pick,nonPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
        {
            return nums[0];
        }
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
       
        int zero = rec(nums,0,n-2,dp);
        Arrays.fill(dp,-1);
        int one = rec(nums,1,n-1,dp);
        return Math.max(zero,one);
    }
}