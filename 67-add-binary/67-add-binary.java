import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        int carry_in = 0;
        String result = "";
        if(a.length() >= b.length()){
            while(a.length() != 0){
                int top = a.length() == 0 ? 0 : Integer.parseInt(String.valueOf(a.charAt(a.length() - 1)));
                int bottom = b.length() == 0 ? 0 : Integer.parseInt(String.valueOf(b.charAt(b.length() - 1)));
                int sum = top ^ bottom ^ carry_in;
                carry_in = (top & bottom) | (carry_in & (top ^ bottom));
                result = sum+""+result;
                if(b.length() != 0){
                    b = b.substring(0, b.length() - 1);
                }
                a = a.substring(0, a.length() - 1);
            }
        }else{
            while(b.length() != 0){
                int top = a.length() == 0 ? 0 : Integer.parseInt(String.valueOf(a.charAt(a.length() - 1)));
                int bottom = b.length() == 0 ? 0 : Integer.parseInt(String.valueOf(b.charAt(b.length() - 1)));
                int sum = top ^ bottom ^ carry_in;
                carry_in = (top & bottom) | (carry_in & (top ^ bottom));
                result = sum+""+result;
                if(a.length() != 0){
                    a = a.substring(0, a.length() - 1);
                }
                b = b.substring(0,b.length() - 1);
            }
        }
        if(carry_in == 1){
            result = carry_in+""+result;
        }
        return result;
        
    }
}