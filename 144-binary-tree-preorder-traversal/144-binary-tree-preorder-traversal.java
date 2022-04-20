/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> pre_order = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)return pre_order;
        pre_order.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        
        return pre_order;
    }
}