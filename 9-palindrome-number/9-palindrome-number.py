class Solution:
    def isPalindrome(self, x: int) -> bool:
        revnum = 0
        original_x = x
        while (x >= 1 ):
            revnum = revnum * 10 + (x % 10)
            x //= 10
        return revnum == original_x