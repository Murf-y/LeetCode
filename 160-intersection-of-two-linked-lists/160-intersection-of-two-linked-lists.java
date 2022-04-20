/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode current_a = headA;
        ListNode current_b = headB;
        while(current_a != null){
            while(current_b != null){
                if(current_a == current_b){
                    return current_b;
                }
                current_b = current_b.next;
            }
            current_a = current_a.next;
            current_b = headB;
        }
        
        return null;
    }
}