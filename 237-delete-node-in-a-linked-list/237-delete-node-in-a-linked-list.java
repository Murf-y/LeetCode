/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        ListNode next = node.next;
        while(next != null){
            int temp = next.val;
            next.val = prev.val;
            prev.val = temp;
            if(next.next == null){
                prev.next = null;
                break;
            }
            prev = next;
            next = next.next;
        }
    }
}