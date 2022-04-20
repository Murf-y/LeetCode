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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode current = head;
        int size = 0;
        while(current != null){
            size++;
            current = current.next;
        }
        int index = 0;
        current = head;
        ListNode prev = head;
        while(current != null){
            if(size - index == n){
                if(prev == current){
                    head = current.next;
                    break;
                }
                prev.next = current.next;
                current.next= null;
                break;
            }
            index++;
            prev = current;
            current = current.next;
        }
        return head;
    }
}