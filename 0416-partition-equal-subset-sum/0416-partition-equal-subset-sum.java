class Solution {
    public Boolean rec(int[]nums,int idx,int totalSum,int sum,Boolean[][]dp)
    {
        if(totalSum-sum == sum) return true;
        if(idx == nums.length) return false;
        if (sum > totalSum / 2) return false;
        if(dp[idx][sum] != null) return dp[idx][sum];
        Boolean take = rec(nums,idx+1,totalSum,sum+nums[idx],dp);
        Boolean notTake = rec(nums,idx+1,totalSum,sum,dp);
        return dp[idx][sum] = take||notTake;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++)
        {
            totalSum+=nums[i];
        }
        Boolean[][]dp = new Boolean[nums.length][totalSum/2+1];
        
        return rec(nums,0,totalSum,0,dp);

    }
}