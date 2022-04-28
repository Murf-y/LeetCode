class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[nums1.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while(l < m && r < n){
            System.out.println(" l is "+ l + " r is " + r + " i is "+ i);
            if(nums1[l] < nums2[r]){
                sorted[i] = nums1[l];
                l++;
                System.out.println("added from left");
            }else{
                sorted[i] = nums2[r];
                r++;
                System.out.println("added from right");
            }
            i++;
        }
        while(l < m){
            sorted[i] = nums1[l];
            i++;
            l++;
        }
        while(r < n){
            sorted[i] = nums2[r];
            i++;
            r++;
        }
        for(i = 0; i < sorted.length; i++){
            nums1[i] = sorted[i];
        }
    }
}