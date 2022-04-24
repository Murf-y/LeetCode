class Solution {
    public int minCostClimbingStairs(int[] cost) {
    int n=cost.length;      
    return Integer.min(mincost(cost,n-1),cost[n-2]);
}
public int mincost(int[] cost,int n){
    if(n<2) return cost[n];
    cost[n] += Integer.min(mincost( cost,(n-1)),cost[n-2] );
    return cost[n];
}
}