class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        
        for(int i = 0; i < nums1.length ; i++){
            for(int j = 0 ; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    int k = j + 1;
                    while(k < nums2.length && nums2[k] < nums1[i]){
                        k++;
                    }
                    if(k == nums2.length){
                        res[i] = -1;
                        break;
                    }else{
                        res[i] = nums2[k];
                        break;
                    }
                }
            }
        }
        return res;
    }
}