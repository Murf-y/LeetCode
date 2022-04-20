/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.Vector;
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        Vector<ListNode> passed_nodes = new Vector<ListNode>();
        ListNode curr = head;
        while(curr.next != null){
            passed_nodes.add(curr);
            curr = curr.next;
            for(ListNode n : passed_nodes){
                if(curr.next == n){
                    return true;
                }
            }
        }
        return false;
    }
}