class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0 ; i < n; i++){
            nums1[m + i] = nums2[i];
        }
        sort(nums1);
    }
    public void sort(int[] nums1){
        for(int i = 1 ; i < nums1.length; i++){
            int j = i;
            while(j > 0 && nums1[j] < nums1[j - 1]){
                int temp = nums1[j];
                nums1[j] = nums1[j-1];
                nums1[j - 1] = temp;
                j--;
            }
        }
    }
}