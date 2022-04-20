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
    public int kthSmallest(TreeNode root, int k) {
        int[] smallest = new int[1];
        inorder(root, new int[]{k}, smallest);
        return smallest[0];
    }
    public void inorder(TreeNode root, int[] counter, int[] smallest) {
        if(root == null || counter[0] == 0) return;
        inorder(root.left, counter, smallest);
        if(--counter[0] == 0){
            smallest[0] = root.val;
        }else{
            inorder(root.right, counter, smallest);
        }
    }
}