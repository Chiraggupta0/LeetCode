import java.util.Arrays;

class Solution {
    int[][] dp;

    public int rec(int[] coins, int amt, int sum, int idx) {
        if (sum == amt) return 0;
        if (idx == coins.length) return Integer.MAX_VALUE;

        if (dp[idx][sum] != -1) return dp[idx][sum];

        int take = Integer.MAX_VALUE;
        if (coins[idx] <= amt - sum) {
            int res = rec(coins, amt, sum + coins[idx], idx);
            if (res != Integer.MAX_VALUE) take = res + 1;
        }

        int nonTake = rec(coins, amt, sum, idx + 1);

        return dp[idx][sum] = Math.min(take, nonTake);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        dp = new int[coins.length][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int ans = rec(coins, amount, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}