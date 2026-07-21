class Solution {

    public int rec(int[] nums, int target, int idx, int sum, int[][] dp, int offset) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (dp[idx][sum + offset] != -1) {
            return dp[idx][sum + offset];
        }
        int pos = rec(nums, target, idx + 1, sum + nums[idx], dp, offset);
        int neg = rec(nums, target, idx + 1, sum - nums[idx], dp, offset);
        return dp[idx][sum + offset] = pos + neg;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (Math.abs(target) > total) return 0;
        int[][] dp = new int[nums.length][2 * total + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(nums, target, 0, 0, dp, total);
    }
}