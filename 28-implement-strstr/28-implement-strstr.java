class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        if(!haystack.contains(needle)) return -1;
        if(needle.length() > haystack.length()) return -1;
        return haystack.indexOf(needle);
    }
}