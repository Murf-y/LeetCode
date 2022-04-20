class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = (high + low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                low = mid+1;
                
            }
            else{
                if(low > mid-1){
                    if(nums[mid] > target){
                        return mid;
                    }else{
                        return mid-1;
                    }
                }
                high = mid-1;
            }
        }
        if(low < 0) return 0;
        return (low);
    }
}