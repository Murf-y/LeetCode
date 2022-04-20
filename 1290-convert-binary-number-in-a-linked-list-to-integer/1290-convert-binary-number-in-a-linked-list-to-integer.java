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
    public int list_size = 0;
    public void set_size(ListNode head){
        ListNode c = head;
        while(c != null){
            list_size++;
            c=c.next;
        }
    }
    public int getDecimalValue(ListNode head) {
        set_size(head);
        return getDecimalValue(head, 1);
    }
    public int getDecimalValue(ListNode head, int i) {
        if(head == null){
            return 0;
        }
        return ((int)(head.val * Math.pow(2, list_size - i))) + getDecimalValue(head.next, i + 1);
    }
}