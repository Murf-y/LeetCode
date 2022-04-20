class Solution {
    public int removeElement(int[] nums, int val) {
        int count=  0;
        for(int i = 0 ;i< nums.length; i++){
            if(nums[i] == val) count++;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                int j = i;
                while(j < nums.length && nums[j] == val){
                    j++;
                }
                if(j != nums.length){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums.length - count;
    }
}