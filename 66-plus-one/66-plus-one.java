import java.math.BigInteger;
class Solution {
    public int[] plusOne(int[] digits) {
        int carry_in = 1;
        int index = digits.length - 1;
        do{
            if(index < 0){
                int[] new_digits = new int[digits.length + 1];
                new_digits[0] = carry_in;
                for(int i = 0; i < digits.length;i++){
                    new_digits[i+1] = digits[i];
                }
                
                digits = new_digits;
                break;
            }
            int total = digits[index] + carry_in;
            if(total >= 10){
                carry_in = total / 10;
                digits[index] = total % 10;
                
                index --;
            }else{
                digits[index] = total;
                carry_in = 0;
            }
        }while(carry_in != 0);
        
        return digits;
    }
}