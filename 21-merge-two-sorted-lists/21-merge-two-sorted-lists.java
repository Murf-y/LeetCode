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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return l1;
        }
        else if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else{
            if(l1.val <= l2.val){
                ListNode rest = l1.next;
                
                l1.next = mergeTwoLists(rest, l2);
                return l1;
            }
            else{
                ListNode rest = l2.next;
                
                l2.next = mergeTwoLists(l1, rest);
                return l2;
            }
        }
        
    }
}