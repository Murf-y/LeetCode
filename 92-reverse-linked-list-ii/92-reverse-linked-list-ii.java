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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        ListNode left_n = null, left_prev = null,right_n = null,right_next = null,prev = null;
        ListNode current = head;
        int current_index = 1;
        
        while(current != null){
            if(current_index == left){
                left_n = current;
                left_prev = prev;
            }
            if(current_index == right){
                right_n = current;
                right_next = current.next;
                
                break;
            }
            current_index++;
            prev = current;
            current = current.next;
        }
        current = left_n;
        prev = right_next;
        while(current != right_next){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        if(left_prev != null){
            left_prev.next = prev;
        }else{
            head = prev;
        }
        return head;
    }
}