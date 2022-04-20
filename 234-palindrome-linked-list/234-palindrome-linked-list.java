/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int size = 0;
    public boolean is_pal = true;
    public int size(ListNode head){
        if(head == null) return 0;
        ListNode c = head;
        int s = 0;
        while(c != null){
            s++;
            c = c.next;
        }
        return s;
    }
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;
        size = size(head);
        isPalindrome(head, 0);
        return is_pal;
    }
    public ListNode isPalindrome(ListNode curr, int n) {
       
        if( size % 2 == 0) {
			if(n == (size/2 )- 1) {
                if(curr.val != curr.next.val) is_pal = false;
				return curr.next;
			}
			else {
				ListNode node =  isPalindrome(curr.next, ++n);
				if(curr.val != node.next.val) is_pal = false;
				return node.next;
			}
		}else{
			if(n == size/2) {
				return curr.next;
			}
			else {
				ListNode node =  isPalindrome(curr.next, ++n);
				if(curr.val != node.val) is_pal = false;
				return node.next;
			}
			
		}
    }
}