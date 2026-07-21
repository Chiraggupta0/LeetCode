class Solution {
    public static int rec(int[]nums,int target,int idx,int sum)
    {
        if(idx == nums.length)
        {
            if(sum == target)
            {
                return 1;
            }
            else return 0;
        }
        int neg = rec(nums,target,idx+1,sum-nums[idx]);
        int pos = rec(nums,target,idx+1,sum+nums[idx]);
        return neg+pos;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums,target,0,0);
    }
}