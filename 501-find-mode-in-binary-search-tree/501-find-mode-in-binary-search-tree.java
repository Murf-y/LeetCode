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
    int[] counter;
    public int[] findMode(TreeNode root) {
        counter = new int[200000];
        inorder(root);
        Vector<Integer> res = new Vector<Integer>();
        int max = 0;
        for(int i = 0 ; i < counter.length;i++){
            if(counter[i] > max) max = counter[i];
        }
        for(int i = 0 ; i < counter.length;i++){
            if(counter[i] == max) res.add(i - 100000);
        }
        int[] result = new int[res.size()];
        int i = 0;
        for(Integer e: res){
            result[i] = e;
            i++;
        }
        return result;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        counter[root.val + 100000]++;
        inorder(root.right);
    }
}