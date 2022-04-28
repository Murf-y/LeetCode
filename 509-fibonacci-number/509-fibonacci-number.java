class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i <= n; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
        
        
        // 0 1 2 3 4 5 6  7  8  9 ...
        // 0 1 1 2 3 5 8 13 21 34 ...
    }
}