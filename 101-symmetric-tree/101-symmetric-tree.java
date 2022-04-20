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
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        if(root.left == null || root.right == null) return false;
        
        return isSymmetricRecu(root.left, root.right);
    }
    
    public boolean isSymmetricRecu(TreeNode rootleft, TreeNode rootright){
        if(rootleft == null && rootright == null){
            return true;
        }
        if(rootleft == null || rootright == null){
            return false;
        }
        
        return rootleft.val == rootright.val && isSymmetricRecu(rootleft.left, rootright.right) && isSymmetricRecu(rootleft.right, rootright.left);
    }
}