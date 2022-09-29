class Solution {
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
                o[o_counter] =  arr[i];
                o_counter++;
                k--;
                i--;
            }
        }
        // O(k ^ 2)
        else if(h < 0){
            int i = 0;
            while(k > 0){
            	o[o_counter] =  arr[i];
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
                o[o_counter] =  x;
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
                   
                	o[o_counter] =  arr[i];
                    o_counter++;
                    i--;
                    k--;
                }else{
                	o[o_counter] =  arr[j];
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
                    	o[o_counter] =  arr[w];
                        o_counter++;
                        k--;
                        w++;
                    }
                }
                if( j >= arr.length){
                    int w = i;
                    while(k >0 && w >=0 ){
                    	o[o_counter] =  arr[w];
                        o_counter++;
                        k--;
                        w--;
                    }
                }
            }
        }
        
        o = recursiveSort(o);
        List<Integer> list = Arrays.stream(o).boxed().toList();
        return list;
    }
    public int[] recursiveSort(int[] o) {
		if(o.length <= 1) return o;

		int mid = o.length/2;
		int[] left = new int[mid];
		int[] right = new int[o.length - mid];
		
		int l_i = 0;
		int r_i = 0;
		for (int i = 0; i < o.length; i++) {
			if(i < mid) {
				left[l_i] = o[i];
				l_i++;
			}else {
				right[r_i] = o[i];
				r_i++;
			}
		}
		
		merge(o, recursiveSort(left), recursiveSort(right));
		return o;
	}
	public void merge(int[] arr, int[] left, int[] right) {
		int l_i = 0;
		int r_i = 0;
		
		int i;
		for (i = 0; i < arr.length; i++) {
			if(l_i >= left.length || r_i >= right.length) {
				break;
			}else {
				if(left[l_i] < right[r_i]) {
					arr[i] = left[l_i];
					l_i++;
				}else {
					arr[i] = right[r_i];
					r_i++;
				}
			}
		}
		
		while(i < arr.length && l_i < left.length) {
			arr[i] = left[l_i];
			i++;
			l_i++;
		}
		while(i < arr.length && r_i < right.length) {
			arr[i] = right[r_i];
			i++;
			r_i++;
		}
		
	}
}