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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        deleteMiddle(head,0);
        return head;
    }
    public int deleteMiddle(ListNode current, int current_index){
        if(current.next == null) return current_index + 1;
        int size = deleteMiddle(current.next, current_index + 1);
        if(size/2 - 1== current_index){
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = null;
        }
        
        return size;
    }
}