class Solution {
    public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		int a = 0;
        int m1 = 1;
        int m2 = 1;
        for(int i = 0; i< s.length(); i++){
            a+=s.charAt(i);
            a-=t.charAt(i);
            m1*=s.charAt(i);
            m2*=t.charAt(i);
        }
        return a == 0 && m1 == m2;
	}
}