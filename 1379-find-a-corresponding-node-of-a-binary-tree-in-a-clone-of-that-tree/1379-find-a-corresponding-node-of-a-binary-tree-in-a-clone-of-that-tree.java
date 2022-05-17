/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null) return null;
        if(cloned.val == target.val) return cloned;
        TreeNode n_1 = getTargetCopy(original.left, cloned.left, target);
        TreeNode n_2 = getTargetCopy(original.right, cloned.right, target);
        return n_1 == null? n_2: n_1;    }
}