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
    
    public TreeNode getRightMost(TreeNode root){
        if(root.right == null) return root;
        return getRightMost(root.right);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        
        // Find the Node, and the Node parent
        TreeNode current = root;
        TreeNode parent = null;
        while(current != null){
            if(current.val == key) break;
            else if(current.val > key){
                parent = current;
                current = current.left;
            }else{
                parent = current;
                current = current.right;
            }
        }
        // If not found return null
        if(current == null) return root;
        
        // If leaf node, just remove it
        if(current.left == null && current.right == null){
            if(parent == null) root = null;
            else if(parent.left == current){
                parent.left = null;
            }else{
                parent.right = null;
            }
            return root;
        }
        // If Node have only one child, replace it with that child
        if(current.left == null){
            if(parent == null) root = current.right;
            else if(parent.left == current){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
            
            return root;
        }
        if(current.right == null){
            if(parent == null) root = current.left;
            else if(parent.left == current){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
            
            return root;
        }
        // Node have 2 childs
        // Get the rightmost of the left of the Node (max in Node left subtree)
        // Keep Track of the rightmost parent
        TreeNode left_right_most_parent = current;
        TreeNode left_right_most = current.left;
        while(left_right_most.right != null){
            left_right_most_parent = left_right_most;
            left_right_most = left_right_most.right;
        }
        
        // If the left right most is not leaf
        // remove it and put its parent left to its left
        if(left_right_most.left == null){
            if(left_right_most_parent == current){
                left_right_most_parent.left = null;
            }else{
                left_right_most_parent.right = null;
            }
        }
        // If the left right most is not leaf
        // remove it and put its parent left to null
        else{
            if(left_right_most_parent == current){
                left_right_most_parent.left = left_right_most.left;
            }else{
                left_right_most_parent.right = left_right_most.left;
            }
        }
        
        
        // Swap current node with left rightmost 
        current.val = left_right_most.val;
        
        return root;
    }
}