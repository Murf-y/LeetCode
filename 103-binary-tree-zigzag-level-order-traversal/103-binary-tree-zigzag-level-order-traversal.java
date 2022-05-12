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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        ArrayList<Integer> level = new ArrayList();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> next_q = new LinkedList<TreeNode>();
        
        if(root == null) return result;
        
        q.add(root);
        while(!q.isEmpty()){
            while(!q.isEmpty()){
                TreeNode n = q.poll();
                level.add(n.val);
                if(n.left != null) next_q.add(n.left);
                if(n.right != null) next_q.add(n.right);
            }
            result.add(level);
            level = new ArrayList();
            q = next_q;
            next_q = new LinkedList();
        }
        int i = 0;
        List<List<Integer>> new_result = new ArrayList();
        for(List<Integer> j : result){
            if(i % 2 != 0){
                new_result.add(reverseArrayList(j));
            }else{
                new_result.add(j);
            }
            i++;
        }
        return new_result;
    }
    public ArrayList<Integer> reverseArrayList(List<Integer> alist)
    {
        
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {
            revArrayList.add(alist.get(i));
        }
 
        return revArrayList;
    }
}