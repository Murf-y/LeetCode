class Solution {
    public boolean isPalindrome(String s) {
        if(s.isBlank()) return true;
        
        for(int i = 0, j = s.length() - 1; i <= j ; i++, j--){
            String l = String.valueOf(s.charAt(i)).toLowerCase();
            String r = String.valueOf(s.charAt(j)).toLowerCase();
            
            while(!l.matches("^[a-zA-Z0-9]*$")){
                i++;
                if(i >= s.length()){
                    l = " ";
                    break;
                }else{
                    l = String.valueOf(s.charAt(i)).toLowerCase();
                }
                
            }
            while(!r.matches("^[a-zA-Z0-9]*$")){
                j--;
                if(j < 0){
                    r = " ";
                    break;
                }else{
                    r = String.valueOf(s.charAt(j)).toLowerCase();
                }
            }
            if(!l.equalsIgnoreCase(r)){
                return false;
            }
        }
        return true;
    }
}