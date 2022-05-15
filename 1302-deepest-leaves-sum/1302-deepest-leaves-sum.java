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
import java.util.Vector;
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        Queue<TreeNode> next_q = new LinkedList();
        Vector<TreeNode> level = new Vector();
        Vector<TreeNode> last_level = new Vector();
        q.add(root);
        while(!q.isEmpty()){
            while(!q.isEmpty()){
                TreeNode n = q.poll();
                level.add(n);
                if(n.left != null) next_q.add(n.left);
                if(n.right != null) next_q.add(n.right);
            }
            last_level = level;
            level = new Vector();
            q = next_q;
            next_q = new LinkedList();
        }
        int result = 0;
        for(TreeNode n: last_level){
            result += n.val;
        }
        return result;
    }
}