class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int l_x = words.length - 1;
        while(words[l_x] == ""){
            l_x -= 1;
        }
        return words[l_x].length();
        
        
    }
}