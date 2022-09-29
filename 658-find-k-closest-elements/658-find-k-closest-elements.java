class Solution {
    public void addToSortedArray(int[] array, int i, int array_size) {
		// Worst case: O(arrayLength)
		
		if(array_size == 0) array[array_size] = i;
		else {
			array[array_size] = i;
			int m = array_size;
			int j = array_size - 1;
			while(j >= 0 && array[j] > array[m]) {
				int temp = array[m];
				array[m] = array[j];
				array[j] = temp;
				m--;
				j--;
			}
		}
	}
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] o = new int[k];
        int o_counter = 0;
        int res = -999;
        int l = 0;
        int h = arr.length - 1;
        
        // O(lg(n))
        while(l <= h){
            int mid = (l+h)/2;
            if(arr[mid] == x) {
                res = mid;
                break;
            }
            else if(arr[mid] < x){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        // O(k^2)
        if(l >= arr.length){
            int i = arr.length - 1;
            while(k > 0){
                addToSortedArray(o, arr[i], o_counter);
                o_counter++;
                k--;
                i--;
            }
        }
        // O(k ^ 2)
        else if(h < 0){
            int i = 0;
            while(k > 0){
            	addToSortedArray(o, arr[i], o_counter);
                o_counter++;
                k--;
                i++;
            }
        }
        // O(k^2)
        else{
            int i;
            int j;
            
            //O(k)
            if(res != -999){
                i = res - 1;
                j = res + 1;
                addToSortedArray(o, x, o_counter);
                o_counter++;
                k--;
            }
            //O(1)
            else{
                i = h;
                j = l;
            }
            // O(k^2)
            while(k > 0 && i >= 0 && j < arr.length){
                if (Math.abs(arr[i] - x) < Math.abs(arr[j] - x) || (Math.abs(arr[i] - x) == Math.abs(arr[j] - x) && arr[i] < arr[j])){
                   
                	addToSortedArray(o, arr[i], o_counter);
                    o_counter++;
                    i--;
                    k--;
                }else{
                	addToSortedArray(o, arr[j], o_counter);
                    o_counter++;
                    j++;
                    k--;
                }
                
            }
            
            //O(k^2)
            if(k > 0){
                if( i < 0){
                    int w = j;
                    while(k >0 && w < arr.length){
                    	addToSortedArray(o, arr[w], o_counter);
                        o_counter++;
                        k--;
                        w++;
                    }
                }
                if( j >= arr.length){
                    int w = i;
                    while(k >0 && w >=0 ){
                    	addToSortedArray(o, arr[w], o_counter);
                        o_counter++;
                        k--;
                        w--;
                    }
                }
            }
        }
        List<Integer> a =  Arrays.stream(o).boxed().collect(Collectors.toList());
        return a;
    }
}