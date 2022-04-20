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
    public int size(ListNode head){
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode current = head;
        
        ListNode current_left = head;
        ListNode current_right = head;
        int size = size(head);
        if(size == 2){
            current_left = head;
            current_right = head.next;
        }else{
            int current_index = 1;
            while(current != null){
                if(current_index == k){
                    current_left = current;
                }
                if(size - current_index == k - 1){
                    current_right = current;
                }
                current_index++;
                current=current.next;
            }
        }
        
        ListNode prevLeft = null;
        ListNode prevRight = null;
        current = head;
        while(current.next != null){
            if(current.next == current_left){
                prevLeft = current;
            }
            if(current.next == current_right){
                prevRight = current;
            }
            
            current = current.next;
        }
        
        if(prevLeft != null){
            prevLeft.next = current_right;
        }else{
            head = current_right;
        }
        if(prevRight != null){
            prevRight.next = current_left;
        }else{
            head = current_left;
        }
        
        ListNode temp_next = current_left.next;
        current_left.next = current_right.next;
        current_right.next = temp_next;
        return head;
    }
}