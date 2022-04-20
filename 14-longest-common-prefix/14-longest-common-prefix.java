class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        else if(strs.length ==1){
            return strs[0];
        }
        String curr_longest = "";
        for(int i = 0 ; i < strs.length-1;i++){
            String curr = "";
            String next = strs[i+1];
            
            
            if(i == 0){
                curr = strs[i];
            }else{
                curr = curr_longest;
            }
            curr_longest = prefixOf(curr,next);
            
        }
        return curr_longest;
    }
    public String prefixOf(String s1, String s2){
        if(s1.equals("") || s2.equals("")){
            return "";
        }
        else if(s1.charAt(0) == s2.charAt(0)){
            return String.valueOf(s1.charAt(0)) + prefixOf(s1.substring(1), s2.substring(1));
        }else{
            return "";
        }
    }
}