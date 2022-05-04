class Solution {
    public String freqAlphabets(String s) {
        String res = "";
        for(int i = s.length() -1; i >= 0; i--){
            String c = String.valueOf(s.charAt(i));
            if(c.equals("#")){
                char b = (char)(Integer.parseInt(s.substring(i-2, i)) + '`');
                res = String.valueOf(b) + res;
                i-=2;
            }
            else{
                char b = (char)(Integer.parseInt(String.valueOf(s.charAt(i))) + '`');
                res = String.valueOf(b) + res;
            }
        }
        return res;
    }
}