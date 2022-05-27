class Solution {
    public int numberOfSteps(int num) {
        return numberOfSteps(num, 0);
    }
    public int numberOfSteps(int num, int steps){
        if(num == 0) return steps;
        return numberOfSteps(num % 2 ==0 ? num/2 : num-1, steps+1);
    }
}