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
    class Pair{
        boolean isBST;
        int min; 
        int max;
        int curSum;
        Pair(boolean isBST, int min, int max, int curSum){
            this.isBST=isBST;
            this.min=min;
            this.max=max;
            this.curSum = curSum;
        }
    }
    int maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        helper(root);
        return maxSum;
    }
    Pair helper(TreeNode root){
        if(root == null) return new Pair(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        if(left.isBST && right.isBST&& left.max<root.val && right.min > root.val){
            int sum = left.curSum+right.curSum+ root.val;
            int min = Math.min(left.min,root.val);
            int max = Math.max(right.max,root.val);
            maxSum = Math.max(maxSum,sum);
            return new Pair(true,min,max,sum);
        }
        return new Pair(false,0,0,0);
    }
}
