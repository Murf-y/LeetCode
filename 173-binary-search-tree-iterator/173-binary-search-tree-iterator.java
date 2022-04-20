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
class BSTIterator {
    int[] numbers;
    int current;
    public BSTIterator(TreeNode root) {
        numbers = new int[size(root)];
        current = 0;
        inorder(root,numbers);
        current = 0;
    }
    public int size(TreeNode root){
        if(root == null) return 0;
        return 1+size(root.left)+size(root.right);
    }
    public void inorder(TreeNode root, int[] numbers){
        if(root == null) return;
        inorder(root.left, numbers);
        numbers[current++] = root.val;
        inorder(root.right, numbers);
    }
    public int next() {
        return numbers[current++];
    }
    
    public boolean hasNext() {
        return current < numbers.length;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */