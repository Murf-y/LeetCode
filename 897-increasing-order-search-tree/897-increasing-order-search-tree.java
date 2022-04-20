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
    TreeNode current_head = null, base_head = null;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return base_head;
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        
        if(current_head != null){
            current_head.right = new TreeNode(root.val);
            current_head = current_head.right;
        }else{
            base_head = root;
            current_head = root;
        }
        inorder(root.right);
    }
}