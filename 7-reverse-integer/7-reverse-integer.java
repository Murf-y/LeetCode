class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE){
            return 0;
        }
        if(x/10 == 0){
            return x;
        }
        
        String a = (x<0 ? -1 * x : x)+"";
        StringBuilder b = new StringBuilder(a);
        long r = Long.parseLong(b.reverse().toString());
        if(r > Integer.MAX_VALUE){
            return 0;
        }
        else{
            return x < 0 ? -1 * (int)r:(int)r;
        }
    }
}