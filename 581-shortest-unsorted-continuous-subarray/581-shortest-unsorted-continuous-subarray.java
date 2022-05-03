class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            copy[i] = nums[i];
        }
        mergeSort(copy);
        
        int start = -1;
        int end = -1;
        for(int i = 0 ; i < nums.length; i++){
            if(copy[i] != nums[i]){
                start = i;
                break;
            }
        }
        if(start != -1){
            for(int i = nums.length - 1 ; i > 0; i--){
                if(copy[i] != nums[i]){
                    end = i;
                    break;
                }
            }
            
            return end - start + 1;
        }else{
            return 0;
        }
    }
    public void mergeSort(int[] nums){
        if(nums.length <= 1) return;
        int left_size = nums.length/2;
        int right_size = nums.length - left_size;
        
        int[] left_part = new int[left_size];
        int[] right_part = new int[right_size];
        for(int i = 0; i < nums.length; i++){
            if(i < left_size) left_part[i] = nums[i];
            else right_part[i - left_size] = nums[i];
        }
        
        mergeSort(left_part);
        mergeSort(right_part);
        
        merge(left_part, right_part, nums);
    }
    
    public void merge(int[] left,int[] right, int[] nums){
        int l=0,r=0,i=0;
        
        while( l < left.length && r < right.length){
            if(left[l] < right[r]){
                nums[i] = left[l];
                l++;
            }
            else{
                nums[i] = right[r];
                r++;
            }
            i++;
        }
        while(l < left.length){
            nums[i] = left[l];
            l++;
            i++;
        }
        while(r < right.length){
            nums[i] = right[r];
            r++;
            i++;
        }
    }
}