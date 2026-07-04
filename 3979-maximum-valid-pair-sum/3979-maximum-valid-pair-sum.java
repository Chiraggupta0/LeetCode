class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int best = nums[0];
        for(int j=k;j<n;j++)
            {
                best = Math.max(best,nums[j-k]);
                max = Math.max(max,best+nums[j]);
            }
        return max;
    }
}