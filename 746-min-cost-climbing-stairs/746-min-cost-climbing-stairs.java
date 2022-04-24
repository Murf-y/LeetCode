class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] cache = new Integer[cost.length];
        return Math.min(minCostClimbingStairs(cost,0, cache), minCostClimbingStairs(cost,1,cache));
    }
    public int minCostClimbingStairs(int[] cost, int index, Integer[] cache) {
        if(index >= cost.length) return 0;
        if(cache[index] != null) return cache[index];
        int one_step = cost[index] + minCostClimbingStairs(cost, index + 1,cache);
        int two_step = cost[index] + minCostClimbingStairs(cost, index + 2,cache);
        cache[index] = Math.min(one_step,two_step);
        return cache[index];
    }
}