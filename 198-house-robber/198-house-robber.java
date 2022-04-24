class Solution {
    public int rob(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        return rob(0,nums,dp);
    }
    public int rob(int i, int[] nums,Integer[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != null) return dp[i];
        dp[i] = Math.max(rob(i+1, nums, dp), nums[i] + rob(i+2, nums,dp));
        return dp[i];
    }
}